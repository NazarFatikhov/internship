package com.company.internship.web.screens.profile;

import com.company.internship.entity.Employee;
import com.haulmont.cuba.gui.screen.*;

@UiController("Employee.browse")
@UiDescriptor("profile-browse.xml")
@LookupComponent("profilesTable")
@LoadDataBeforeShow
public class ProfileBrowse extends StandardLookup<Employee> {
}