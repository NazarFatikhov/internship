package com.company.internship.web.screens.profile;

import com.company.internship.entity.Employee;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.core.global.PasswordEncryption;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;

@UiController("Employee.edit")
@UiDescriptor("profile-edit.xml")
@EditedEntityContainer("profileDc")
@LoadDataBeforeShow
public class ProfileEdit extends StandardEditor<Employee> {

    @Inject
    private TextArea<String> passwordField;
    @Inject
    private PasswordEncryption passwordEncryption;
    @Inject
    private ExportDisplay exportDisplay;
    @Inject
    private InstanceContainer<Employee> profileDc;
    @Inject
    private Image image;
    @Inject
    private FileUploadField uploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private Button downloadImageBtn;
    @Inject
    private Button clearImageBtn;

    @Subscribe
    private void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        encodeProfileEntityPassword();
    }

    @Subscribe
    protected void onInit(InitEvent event) {
        uploadField.addFileUploadSucceedListener(uploadSucceedEvent -> {
            FileDescriptor fd = uploadField.getFileDescriptor();
            try {
                fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(), fd);
            } catch (FileStorageException e) {
                throw new RuntimeException("Error saving file to FileStorage", e);
            }
            getEditedEntity().setAvatar(dataManager.commit(fd));
            displayImage();
        });

        uploadField.addFileUploadErrorListener(uploadErrorEvent ->
                notifications.create()
                        .withCaption("File upload error")
                        .show());

        profileDc.addItemPropertyChangeListener(employeeItemPropertyChangeEvent -> {
            if ("imageFile".equals(employeeItemPropertyChangeEvent.getProperty()))
                updateImageButtons(employeeItemPropertyChangeEvent.getValue() != null);
        });
    }

    @Subscribe
    protected void onAfterShow(AfterShowEvent event) {
        displayImage();
        updateImageButtons(getEditedEntity().getAvatar() != null);
    }

    public void onDownloadImageBtnClick() {
        if (profileDc.getItem().getAvatar() != null)
            exportDisplay.show(profileDc.getItem().getAvatar(), ExportFormat.OCTET_STREAM);
    }

    public void onClearImageBtnClick() {
        getEditedEntity().setAvatar(null);
        displayImage();
    }

    private void updateImageButtons(boolean enable) {
        downloadImageBtn.setEnabled(enable);
        clearImageBtn.setEnabled(enable);
    }

    private void displayImage() {
        if (getEditedEntity().getAvatar() != null) {
            image.setSource(FileDescriptorResource.class).setFileDescriptor(getEditedEntity().getAvatar());
            image.setVisible(true);
        } else {
            image.setVisible(false);
        }
    }

    //Method take value from password field, hash it, then write into entity
    private void encodeProfileEntityPassword(){
        getEditedEntity().setHashPassword(passwordEncryption.getPasswordHash(getEditedEntity().getId(), passwordField.getRawValue()));
    }
}