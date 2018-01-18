DROP DATABASE rll ;
CREATE DATABASE rll CHARACTER SET UTF8 ;
USE rll ;
-- 1、创建部门信息表
CREATE TABLE dept (
   did                  int	AUTO_INCREMENT ,
   dname                varchar(50),
   eid					varchar(50),
   maxnum				int ,
   currnum				int ,
   CONSTRAINT pk_did primary key (did)
) engine='innodb';
-- 2、创建职位信息表
CREATE TABLE level (
   lid                  int ,
   title                varchar(50),
   losal				double ,
   hisal				double ,
   CONSTRAINT pk_lid PRIMARY KEY (lid)
) engine='innodb';

-- 3、创建雇员信息表
CREATE TABLE emp (
   eid                  varchar(50) not null,
   lid                  int,
   did                  int,
   sex					   int,
   etid				      int,
   ename                varchar(50),
   salary				   double ,
   phone                varchar(20),
   password             varchar(32),
   photo                varchar(200),
   empnote              text,
   hiredate             datetime,
   ineid                varchar(50) ,
   state				   int ,
   leavedate			datetime,
   leavenote			text,
   outeid				varchar(50),
   lastdate          datetime,
   CONSTRAINT pk_eid PRIMARY KEY (eid)
) engine='innodb';
-- 4、创建角色信息表
CREATE TABLE role (
   rid                  varchar(50) ,
   title                varchar(50),
   CONSTRAINT pk_rid PRIMARY KEY (rid)
) engine='innodb';
-- 5、创建权限信息表
CREATE TABLE action (
   actid                varchar(50),
   rid                  varchar(50),
   title                varchar(50),
   CONSTRAINT pk_actid PRIMARY KEY (actid)
) engine='innodb';
-- 6、创建职务角色关系表
CREATE TABLE dept_role(
   did                  int,
   rid                  varchar(50)
) engine='innodb';
-- 7、创建工种表
CREATE TABLE emptype(
	etid	               int	AUTO_INCREMENT ,
	title	               varchar(20) ,
	CONSTRAINT pk_etid PRIMARY KEY (etid)
) engine='innodb';


-- 增加员工等级信息
INSERT INTO level(lid,title,losal,hisal) VALUES (0,'总裁',10001.00,99999.00) ;
INSERT INTO level(lid,title,losal,hisal) VALUES (1,'部门经理',3001.00,15000.00) ;
INSERT INTO level(lid,title,losal,hisal) VALUES (2,'普通员工',2001.00,8000.00) ;

-- 增加工种信息
INSERT INTO emptype(etid,title) VALUES (1,'管理') ;
INSERT INTO emptype(etid,title) VALUES (2,'焊工') ;
INSERT INTO emptype(etid,title) VALUES (3,'普工') ;

-- 增加部门信息
INSERT INTO dept (dname,maxnum,currnum) VALUES ('管理部',10,0) ;
INSERT INTO dept (dname,maxnum,currnum) VALUES ('人事部',10,0) ;
INSERT INTO dept (dname,maxnum,currnum) VALUES ('财务部',10,0) ;
INSERT INTO dept (dname,maxnum,currnum) VALUES ('营销部',10,0) ;
INSERT INTO dept (dname,maxnum,currnum) VALUES ('市场部',10,0) ;
INSERT INTO dept (dname,maxnum,currnum) VALUES ('规划部',10,0) ;
INSERT INTO dept (dname,maxnum,currnum) VALUES ('仓储部',10,0) ;
INSERT INTO dept (dname,maxnum,currnum) VALUES ('生产部',1000,0) ;

-- 增加员工信息
-- 管理部总裁，用户名：mxr-president / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-president',0,1,1,1,'管理部总裁',50000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','nophoto.png','很好的员工','2018-01-10','mxr-raoleilei',1,'2018-01-10 11:11:11') ;

-- 人事部经理，用户名：mxr-human / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-human',1,2,1,1,'人事部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','nophoto.png','很好的员工','2018-01-10','mxr-president',1,'2018-01-10 11:11:11') ;
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('test',1,3,1,1,'test',10000,'010-110','','nophoto.png','很好的员工','2018-01-10','mxr-president',1,'2018-01-10 11:11:11') ;


-- 财务部经理，用户名：mxr-finance / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-finance',1,3,1,1,'财务部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 营销部经理，用户名：mxr-sale / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-sale',1,4,1,1,'营销部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 市场部经理，用户名：mxr-market / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-market',1,5,1,1,'市场部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 规划部经理，用户名：mxr-plan / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-plan',1,6,1,1,'规划部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 仓储部经理，用户名：mxr-warehouse / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-warehouse',1,7,1,1,'仓储部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 生产部经理，用户名：mxr-product / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-product',1,8,1,1,'生产部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 增加部门经理信息
UPDATE dept SET eid='mxr-president' WHERE did=1 ;
UPDATE dept SET eid='mxr-human' WHERE did=2 ;
UPDATE dept SET eid='mxr-finance' WHERE did=3 ;
UPDATE dept SET eid='mxr-sale' WHERE did=4 ;
UPDATE dept SET eid='mxr-market' WHERE did=5 ;
UPDATE dept SET eid='mxr-plan' WHERE did=6 ;
UPDATE dept SET eid='mxr-warehouse' WHERE did=7 ;
UPDATE dept SET eid='mxr-product' WHERE did=8 ;

-- 更新部门对应人数
UPDATE dept SET currnum=2 WHERE did=1 ;
UPDATE dept SET currnum=3 WHERE did=2 ;
UPDATE dept SET currnum=4 WHERE did=3 ;
UPDATE dept SET currnum=8 WHERE did=4 ;
UPDATE dept SET currnum=6 WHERE did=5 ;
UPDATE dept SET currnum=9 WHERE did=6 ;
UPDATE dept SET currnum=16 WHERE did=7 ;

-- 增加角色信息
INSERT INTO role(rid,title) VALUES ('dept','【人事部】部门信息管理') ;
INSERT INTO role(rid,title) VALUES ('emp','【人事部】雇员信息管理') ;
INSERT INTO role(rid,title) VALUES ('warehouse','【仓储部】仓库信息管理') ;
INSERT INTO role(rid,title) VALUES ('customer','【营销部】客户信息管理') ;
INSERT INTO role(rid,title) VALUES ('ucgoods','【市场部】半成品信息管理') ;
INSERT INTO role(rid,title) VALUES ('cgoods','【市场部】成品信息管理') ;
INSERT INTO role(rid,title) VALUES ('ucgoodsstorage','【市场部】半成品入库管理') ;
INSERT INTO role(rid,title) VALUES ('ucgoodsstorageaudit','【财务部】半成品入库审核管理') ;
INSERT INTO role(rid,title) VALUES ('ucgoodsmanage','【仓储部】半成品管理') ;
INSERT INTO role(rid,title) VALUES ('plant','【生产部】生产车间管理') ;
INSERT INTO role(rid,title) VALUES ('productplan','【规划部】生产计划管理') ;
INSERT INTO role(rid,title) VALUES ('productplanucgoods','【仓储部】生产计划原材料管理') ;
INSERT INTO role(rid,title) VALUES ('replenishapplication','【仓储部】补货申请管理') ;
INSERT INTO role(rid,title) VALUES ('warehousereplenish','【市场部】仓储补货管理') ;
INSERT INTO role(rid,title) VALUES ('product','【生产部】生产成品管理') ;
INSERT INTO role(rid,title) VALUES ('cgoodsmanage','【仓储部】成品管理') ;

-- 增加权限信息
INSERT INTO action(actid,rid,title) VALUES ('dept:list','dept','部门列表') ;
INSERT INTO action(actid,rid,title) VALUES ('dept:edit','dept','部门编辑') ;
INSERT INTO action(actid,rid,title) VALUES ('dept:add','dept','部门增加') ;
INSERT INTO action(actid,rid,title) VALUES ('emp:list','emp','雇员列表') ;
INSERT INTO action(actid,rid,title) VALUES ('emp:add','emp','雇员增加') ;
INSERT INTO action(actid,rid,title) VALUES ('emp:edit','emp','雇员编辑') ;
INSERT INTO action(actid,rid,title) VALUES ('emp:state','emp','雇员离职') ;
INSERT INTO action(actid,rid,title) VALUES ('warehouse:add','warehouse','仓库增加') ;
INSERT INTO action(actid,rid,title) VALUES ('warehouse:edit','warehouse','仓库编辑') ;
INSERT INTO action(actid,rid,title) VALUES ('warehouse:list','warehouse','仓库列表') ;
INSERT INTO action(actid,rid,title) VALUES ('customer:add','customer','客户增加') ;
INSERT INTO action(actid,rid,title) VALUES ('customer:edit','customer','客户编辑') ;
INSERT INTO action(actid,rid,title) VALUES ('customer:list','customer','客户列表') ;
INSERT INTO action(actid,rid,title) VALUES ('ucgoods:add','ucgoods','半成品增加') ;
INSERT INTO action(actid,rid,title) VALUES ('ucgoods:edit','ucgoods','半成品编辑') ;
INSERT INTO action(actid,rid,title) VALUES ('ucgoods:list','ucgoods','半成品列表') ;
INSERT INTO action(actid,rid,title) VALUES ('ucgoods:show','ucgoods','半成品信息') ;
INSERT INTO action(actid,rid,title) VALUES ('cgoods:add','cgoods','成品增加') ;
INSERT INTO action(actid,rid,title) VALUES ('cgoods:edit','cgoods','成品编辑') ;
INSERT INTO action(actid,rid,title) VALUES ('cgoods:list','cgoods','成品列表') ;
INSERT INTO action(actid,rid,title) VALUES ('cgoods:show','cgoods','成品信息') ;
INSERT INTO action(actid,rid,title) VALUES ('ucgoodsstorage:add','ucgoodsstorage','半成品入库增加') ;
INSERT INTO action(actid,rid,title) VALUES ('ucgoodsstorage:edit','ucgoodsstorage','半成品入库修改') ;
INSERT INTO action(actid,rid,title) VALUES ('ucgoodsstorage:list','ucgoodsstorage','半成品入库列表') ;
INSERT INTO action(actid,rid,title) VALUES ('ucgoodsstorageaudit:edit','ucgoodsstorageaudit','半成品入库审核修改') ;
INSERT INTO action(actid,rid,title) VALUES ('ucgoodsstorageaudit:list','ucgoodsstorageaudit','半成品入库审核列表') ;
INSERT INTO action(actid,rid,title) VALUES ('ucgoodsmanage:storage','ucgoodsmanage','半成品入库处理') ;
INSERT INTO action(actid,rid,title) VALUES ('plant:list','plant','车间列表') ;
INSERT INTO action(actid,rid,title) VALUES ('plant:edit','plant','车间编辑') ;
INSERT INTO action(actid,rid,title) VALUES ('plant:add','plant','车间增加') ;
INSERT INTO action(actid,rid,title) VALUES ('productplan:list','productplan','生产计划列表') ;
INSERT INTO action(actid,rid,title) VALUES ('productplan:edit','productplan','生产计划编辑') ;
INSERT INTO action(actid,rid,title) VALUES ('productplan:add','productplan','成产计划增加') ;
INSERT INTO action(actid,rid,title) VALUES ('productplan:send','productplan','发货') ;
INSERT INTO action(actid,rid,title) VALUES ('productplanucgoods:list','productplanucgoods','生产计划原材料列表') ;
INSERT INTO action(actid,rid,title) VALUES ('productplanucgoods:edit','productplanucgoods','生产计划原材料编辑') ;
INSERT INTO action(actid,rid,title) VALUES ('replenishapplication:list','replenishapplication','补货申请列表') ;
INSERT INTO action(actid,rid,title) VALUES ('replenishapplication:edit','replenishapplication','补货申请编辑') ;
INSERT INTO action(actid,rid,title) VALUES ('replenishapplication:add','replenishapplication','补货申请增加') ;
INSERT INTO action(actid,rid,title) VALUES ('warehousereplenish:list','warehousereplenish','仓储补货列表') ;
INSERT INTO action(actid,rid,title) VALUES ('product:list','product','生产成品列表') ;
INSERT INTO action(actid,rid,title) VALUES ('cgoodsmanage:output','cgoodsmanage','成品入库处理') ;


-- 部门与角色关联
INSERT INTO dept_role(did,rid) VALUES (1,'dept') ;
INSERT INTO dept_role(did,rid) VALUES (2,'dept') ;

INSERT INTO dept_role(did,rid) VALUES (1,'emp') ;
INSERT INTO dept_role(did,rid) VALUES (2,'emp') ;

INSERT INTO dept_role(did,rid) VALUES (1,'warehouse') ;
INSERT INTO dept_role(did,rid) VALUES (7,'warehouse') ;
INSERT INTO dept_role(did,rid) VALUES (1,'ucgoodsmanage') ;
INSERT INTO dept_role(did,rid) VALUES (7,'ucgoodsmanage') ;

INSERT INTO dept_role(did,rid) VALUES (1,'customer') ;
INSERT INTO dept_role(did,rid) VALUES (4,'customer') ;

INSERT INTO dept_role(did,rid) VALUES (1,'ucgoods') ;
INSERT INTO dept_role(did,rid) VALUES (5,'ucgoods') ;
INSERT INTO dept_role(did,rid) VALUES (1,'cgoods') ;
INSERT INTO dept_role(did,rid) VALUES (5,'cgoods') ;
INSERT INTO dept_role(did,rid) VALUES (1,'ucgoodsstorage') ;
INSERT INTO dept_role(did,rid) VALUES (5,'ucgoodsstorage') ;

INSERT INTO dept_role(did,rid) VALUES (1,'ucgoodsstorageaudit') ;
INSERT INTO dept_role(did,rid) VALUES (3,'ucgoodsstorageaudit') ;

INSERT INTO dept_role(did,rid) VALUES (1,'plant') ;
INSERT INTO dept_role(did,rid) VALUES (8,'plant') ;

INSERT INTO dept_role(did,rid) VALUES (1,'productplan') ;
INSERT INTO dept_role(did,rid) VALUES (6,'productplan') ;

INSERT INTO dept_role(did,rid) VALUES (1,'productplanucgoods') ;
INSERT INTO dept_role(did,rid) VALUES (7,'productplanucgoods') ;

INSERT INTO dept_role(did,rid) VALUES (1,'replenishapplication') ;
INSERT INTO dept_role(did,rid) VALUES (7,'replenishapplication') ;

INSERT INTO dept_role(did,rid) VALUES (1,'warehousereplenish') ;
INSERT INTO dept_role(did,rid) VALUES (5,'warehousereplenish') ;

INSERT INTO dept_role(did,rid) VALUES (1,'product') ;
INSERT INTO dept_role(did,rid) VALUES (8,'product') ;

INSERT INTO dept_role(did,rid) VALUES (1,'cgoodsmanage') ;
INSERT INTO dept_role(did,rid) VALUES (7,'cgoodsmanage') ;
