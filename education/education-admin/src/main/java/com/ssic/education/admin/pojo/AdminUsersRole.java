package com.ssic.education.admin.pojo;

public class AdminUsersRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin_users_role.id
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin_users_role.user_id
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin_users_role.role_id
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_admin_users_role.stat
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    private Integer stat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin_users_role.id
     *
     * @return the value of t_admin_users_role.id
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin_users_role.id
     *
     * @param id the value for t_admin_users_role.id
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin_users_role.user_id
     *
     * @return the value of t_admin_users_role.user_id
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin_users_role.user_id
     *
     * @param userId the value for t_admin_users_role.user_id
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin_users_role.role_id
     *
     * @return the value of t_admin_users_role.role_id
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin_users_role.role_id
     *
     * @param roleId the value for t_admin_users_role.role_id
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_admin_users_role.stat
     *
     * @return the value of t_admin_users_role.stat
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    public Integer getStat() {
        return stat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_admin_users_role.stat
     *
     * @param stat the value for t_admin_users_role.stat
     *
     * @mbggenerated Tue Mar 15 11:13:39 CST 2016
     */
    public void setStat(Integer stat) {
        this.stat = stat;
    }
}