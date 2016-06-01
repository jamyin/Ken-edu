START TRANSACTION;

#初始化教委
insert into t_edu_committee(id,name,area_code,type,create_time,last_update_time,stat) values
(UUID(),'上海市教委','310100',1,now(),now(),1),
(UUID(),'黄浦区教委','310101',2,now(),now(),1),
(UUID(),'静安区教委','310106',2,now(),now(),1),
(UUID(),'徐汇区教委','310104',2,now(),now(),1),
(UUID(),'长宁区教委','310105',2,now(),now(),1),
(UUID(),'普陀区教委','310107',2,now(),now(),1),
(UUID(),'虹口区教委','310109',2,now(),now(),1),
(UUID(),'杨浦区教委','310110',2,now(),now(),1),
(UUID(),'闵行区教委','310112',2,now(),now(),1),
(UUID(),'嘉定区教委','310114',2,now(),now(),1),
(UUID(),'宝山区教委','310113',2,now(),now(),1),
(UUID(),'浦东新区教委','310115',2,now(),now(),1),
(UUID(),'松江区教委','310117',2,now(),now(),1),
(UUID(),'金山区教委','310116',2,now(),now(),1),
(UUID(),'青浦区教委','310118',2,now(),now(),1),
(UUID(),'奉贤区教委','310120',2,now(),now(),1),
(UUID(),'崇明县教委','310230',2,now(),now(),1);

#初始化教委用户账号
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,0,1,now(),now(),1 from t_edu_committee where name = '上海市教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '黄浦区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '静安区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '徐汇区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '长宁区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '普陀区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '虹口区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '杨浦区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '闵行区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '嘉定区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '宝山区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '浦东新区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '松江区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '金山区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '青浦区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '奉贤区教委';
insert into t_edu_users(id,name,user_account,password,source_id,source_type,isAdmin,create_time,last_update_time,stat)
select UUID(),name,name,md5("123456"),id,2,1,now(),now(),1 from t_edu_committee where name = '崇明县教委';

commit;