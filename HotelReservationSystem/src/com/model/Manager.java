package com.model;

public class Manager {

    private String managerId;
    private String managerName;

    public Manager() {
    }

    public Manager(String managerId, String managerName) {
        this.managerId = managerId;
        this.managerName = managerName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}