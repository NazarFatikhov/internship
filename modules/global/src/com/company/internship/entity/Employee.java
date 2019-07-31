package com.company.internship.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NamePattern("%s|firstName")
@Table(name = "profile")
@Entity(name = "Employee")
public class Employee extends StandardEntity {
    private static final long serialVersionUID = -394654031888897522L;

    // Name info
    // ---
    @NotNull
    @Column(name = "username", nullable = false, unique = true)
    protected String username;

    @NotNull
    @Column(name = "nickname", nullable = false)
    protected String nickname;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "display_name")
    protected String displayName;
    //---

    //About yourself
    //---
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_file_id")
    protected FileDescriptor avatar;

    @Column(name = "biographical_info", length = 1023)
    protected String biographicalInfo;
    //---


    //Contact info
    //---
    @Column(name = "website")
    protected String website;

    @Email
    @Column(name = "email")
    protected String email;
    //---

    //Account management
    //---
    @NotNull
    @Lob
    @Column(name = "hash_password", nullable = false)
    protected String hashPassword;
    //---

    //WP ERP Role
    //---
    @Column(name = "IS_HR_MANAGER")
    protected Boolean isHRManager;

    @Column(name = "IS_RECRUITER")
    protected Boolean isRecruiter;

    @Column(name = "IS_CRM_MANAGER")
    protected Boolean isCRMManager;

    @Column(name = "IS_CRM_AGENT")
    protected Boolean isCRMAgent;

    @Column(name = "IS_ACCOUNTING_MANAGER")
    protected Boolean isAccountingManager;
    //---

    //ERP Employee Settings
    //---
    @Column(name = "IS_NOTIFIABLE")
    protected Boolean isChoosingNotifications;
    //---

    //Visual Editor
    //---
    @Column(name = "IS_CHOOSING_VISUAL_EDITOR")
    protected Boolean isChoosingVisualEditor;

    @Column(name = "IS_CHOOSING_SYNTAX_HIGHLIGHTING")
    protected Boolean isChoosingSyntaxHighlighting;

    @Column(name = "admin_color_scheme")
    protected String adminColorScheme;

    @Column(name = "IS_CHOOSING_KEYBOARD_STRUCTS")
    protected Boolean isChoosingKeyboardStructs;

    @Column(name = "IS_CHOOSING_TOOLBAR")
    protected Boolean isChoosingToolbar;
    //---

    public void setAdminColorScheme(AdminColorScheme adminColorScheme) {
        this.adminColorScheme = adminColorScheme == null ? null : adminColorScheme.getId();
    }

    public AdminColorScheme getAdminColorScheme() {
        return adminColorScheme == null ? null : AdminColorScheme.fromId(adminColorScheme);
    }

    public Boolean getIsChoosingToolbar() {
        return isChoosingToolbar;
    }

    public void setIsChoosingToolbar(Boolean isChoosingToolbar) {
        this.isChoosingToolbar = isChoosingToolbar;
    }

    public Boolean getIsChoosingKeyboardStructs() {
        return isChoosingKeyboardStructs;
    }

    public void setIsChoosingKeyboardStructs(Boolean isChoosingKeyboardStructs) {
        this.isChoosingKeyboardStructs = isChoosingKeyboardStructs;
    }

    public Boolean getIsChoosingSyntaxHighlighting() {
        return isChoosingSyntaxHighlighting;
    }

    public void setIsChoosingSyntaxHighlighting(Boolean isChoosingSyntaxHighlighting) {
        this.isChoosingSyntaxHighlighting = isChoosingSyntaxHighlighting;
    }

    public Boolean getIsChoosingVisualEditor() {
        return isChoosingVisualEditor;
    }

    public void setIsChoosingVisualEditor(Boolean isChoosingVisualEditor) {
        this.isChoosingVisualEditor = isChoosingVisualEditor;
    }

    public Boolean getIsChoosingNotifications() {
        return isChoosingNotifications;
    }

    public void setIsChoosingNotifications(Boolean isChoosingNotifications) {
        this.isChoosingNotifications = isChoosingNotifications;
    }

    public void setIsRecruiter(Boolean isRecruiter) {
        this.isRecruiter = isRecruiter;
    }

    public Boolean getIsRecruiter() {
        return isRecruiter;
    }

    public void setIsCRMManager(Boolean isCRMManager) {
        this.isCRMManager = isCRMManager;
    }

    public Boolean getIsCRMManager() {
        return isCRMManager;
    }

    public Boolean getIsAccountingManager() {
        return isAccountingManager;
    }

    public void setIsAccountingManager(Boolean isAccountingManager) {
        this.isAccountingManager = isAccountingManager;
    }

    public Boolean getIsCRMAgent() {
        return isCRMAgent;
    }

    public void setIsCRMAgent(Boolean isCRMAgent) {
        this.isCRMAgent = isCRMAgent;
    }

    public Boolean getIsHRManager() {
        return isHRManager;
    }

    public void setIsHRManager(Boolean isHRManager) {
        this.isHRManager = isHRManager;
    }

    public String getBiographicalInfo() {
        return biographicalInfo;
    }

    public void setBiographicalInfo(String biographicalInfo) {
        this.biographicalInfo = biographicalInfo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public void setAvatar(FileDescriptor avatar) {
        this.avatar = avatar;
    }

    public FileDescriptor getAvatar() {
            return avatar;
    }

    public DisplayName getDisplayName() {
        return displayName == null ? null : DisplayName.fromId(displayName);
    }

    public void setDisplayName(DisplayName displayName) {
        this.displayName = displayName == null ? null : displayName.getId();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}