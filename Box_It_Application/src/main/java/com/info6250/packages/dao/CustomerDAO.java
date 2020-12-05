package com.info6250.packages.dao;

import com.info6250.packages.entities.Workspace;

public interface CustomerDAO {

	void createWorkspace(Workspace workspace);
	void addItems(Workspace workspace);

}
