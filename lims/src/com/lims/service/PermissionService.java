package com.lims.service;

import java.util.List;

import com.lims.entity.Permission;

public interface PermissionService {

	public List<Permission> getUsersPermissionByRole(int role, int pid);

}
