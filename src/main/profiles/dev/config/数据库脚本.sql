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
   CONSTRAINT pk_did PRIMARY KEY (did)
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
-- 8、创建省份表
CREATE TABLE province (
   pid                  int AUTO_INCREMENT ,
   title                varchar(50) ,
   CONSTRAINT pk_pid PRIMARY KEY (pid)
) engine='innodb';
-- 9、创建城市表
CREATE TABLE city (
   cid                  int AUTO_INCREMENT ,
   pid                  int,
   title                varchar(50) ,
   CONSTRAINT pk_cid PRIMARY KEY (cid) 
) engine='innodb';
-- 10、创建仓库信息表
CREATE TABLE warehouse (
   wid         int         AUTO_INCREMENT ,
   name        varchar(50) ,
   pid         int ,
   cid         int ,
   wiid        int ,
   address     varchar(50) ,
   photo       varchar(200) ,
   note        text ,
   recorder    varchar(50) ,
   recorddate  datetime ,
   flag        int ,
   CONSTRAINT pk_wid PRIMARY KEY(wid)
) engine='innodb' ;
-- 11、半成品信息表
CREATE TABLE ucgoods(
   ucid                 int         auto_increment ,   
   name                 varchar(50) ,
   price                double ,
   size                 varchar(50) ,
   unit                 int , 
   photo                varchar(200) ,
   note                 text ,
   lastin               datetime ,
   stornum              int ,
   recorder             varchar(50) ,
   flag                 int ,
   CONSTRAINT pk_ucid PRIMARY KEY(ucid)
) engine='innodb' ;
-- 12、创建半成品入库申请单
CREATE TABLE ucgoods_storage_apply(
   usaid                varchar(50) ,
   title                varchar(50) ,
   pid                  int ,
   cid                  int ,
   wid                  int ,
   note                 text ,
   status               int ,
   appmid               varchar(50) ,
   appdate              datetime ,
   sendmid              varchar(50) ,
   senddate             datetime ,
   auditmid             varchar(50) ,
   auditdate            datetime , 
   auditnote            varchar(50) ,
   flag                 int ,
   CONSTRAINT pk_usaid PRIMARY KEY (usaid)
) engine='innodb';
-- 13、创建半成品入库申请单详情
CREATE TABLE ucgoods_storage_apply_details(
   usadid               int      auto_increment ,
   usaid                varchar(50) ,
   ucid                 int ,
   name                 varchar(50) ,
   size                 varchar(50) ,
   price                double ,
   unit                 int ,
   num                  int ,
   totalprice           double ,
   CONSTRAINT pk_usadid PRIMARY KEY (usadid)
) engine='innodb' ;
-- 14、创建半成品合同号和入库单号
CREATE TABLE ucgoods_storage_apply_warehouse(
   usawid               varchar(50) ,
   usaid                varchar(50) ,
   note                 text ,
   date                 datetime ,
   inmid                varchar(50) ,
   CONSTRAINT pk_usawid  PRIMARY KEY (usawid)
) engine='innodb' ;
-- 15、创建半成品入库记录表
CREATE TABLE ucgoods_storage_apply_record(
   usarid               bigint    auto_increment ,
   usawid               varchar(50) ,
   ucid                 int ,
   wid                  int ,
   name                 varchar(50) ,
   size                 varchar(50) ,
   price                double ,
   unit                 int ,
   num                  int ,
   totalprice           double ,
   date                 datetime ,
   CONSTRAINT pk_usarid PRIMARY KEY (usarid)
) engine='innodb' ;
-- 16、创建仓库半成品表
CREATE TABLE warehouse_ucgoods(
   wuid                 int      auto_increment ,
   wid                  int ,
   ucid                 int ,
   name                 varchar(50) ,
   size                 varchar(50) ,
   unit                 int ,
   num                  int ,
   CONSTRAINT pk_wuid PRIMARY KEY (wuid)   
) engine='innodb' ;
-- 17、创建成品表
CREATE TABLE cgoods(
   cid                  int      auto_increment ,
   name                 varchar(50) ,
   price                double ,
   size                 varchar(50) ,
   photo                varchar(50) ,
   note                 varchar(50) ,
   lastin               datetime ,
   recorder             varchar(50) ,
   flag                 int ,
   CONSTRAINT pk_cid PRIMARY KEY (cid)       
) engine='innodb' ;
-- 18、创建成品半成品表
CREATE TABLE cgoods_ucgoods(
   cuid                 int      auto_increment ,
   cid                  int ,
   ucid                 int ,
   name                 varchar(50) ,
   size                 varchar(50) ,
   unit                 int ,
   num                  int ,
   CONSTRAINT pk_cuid PRIMARY KEY (cuid)
) engine='innodb' ;
-- 19、创建补货申请表
CREATE TABLE replenish_apply(
   raid                 int      auto_increment ,
   name                 varchar(50) ,
   pid                  int ,
   cid                  int ,
   ucwid                int ,
   note                 text ,
   status               int ,
   appmid               varchar(50) ,
   appdate              datetime ,
   sendmid              varchar(50) ,
   senddate             datetime ,
   watchmid             varchar(50) ,
   watchdate            datetime ,
   flag                 int ,
   CONSTRAINT pk_raid PRIMARY KEY (raid)
) engine='innodb' ;
-- 20、创建补货详情表
CREATE TABLE replenish_apply_details(
   radid                int      auto_increment ,
   raid                 int,
   ucid                 int,
   name                 varchar(50) ,
   size                 varchar(50) ,
   price                double ,
   unit                 int ,
   num                  int,
   totalprice           double,
   CONSTRAINT pk_radid PRIMARY KEY (radid)
) engine='innodb' ;
-- 21、定义客户等级表
CREATE TABLE citem (
   ciid  int auto_increment ,
   title varchar(50) ,
   CONSTRAINT pk_ciid PRIMARY KEY(ciid)
) engine='innodb' ;
-- 22、创建客户表
CREATE TABLE customer(
   ctid                 int      auto_increment ,
   name                 varchar(50) ,
   ciid                 int ,
   pid                  int ,
   cid                  int ,
   address              varchar(50) ,
   account              varchar(50) ,
   openbank             varchar(50) ,
   dutypara             varchar(50) ,
   fax                  varchar(50) ,
   lname                varchar(50) ,
   phone                varchar(20) ,
   photo                varchar(50) ,
   note                 text ,
   indate               datetime ,
   recorder             varchar(50) ,
   flag                 int ,
   CONSTRAINT pk_ctid PRIMARY KEY (ctid)
) engine='innodb' ;
-- 23、创建车间表
CREATE TABLE plant(
   plid                 int        auto_increment ,
   name                 varchar(50) ,
   phone                varchar(20) ,
   pid                  int ,
   cid                  int ,
   address              varchar(50) ,
   photo                varchar(50) ,
   note                 text ,
   recorder             varchar(50) ,
   flag                 int ,
   CONSTRAINT pk_plid PRIMARY KEY(plid)
) engine='innodb' ;
-- 24、创建生产计划表
CREATE TABLE product_plan(
   ppid                 int        auto_increment ,
   ctid                 int ,
   ucwid                int ,
   cwid                 int ,
   plid                 int ,
   plandate             datetime , 
   note                 text ,
   status               int ,
   appmid               varchar(50) ,
   appdate              datetime ,
   plansendmid          varchar(50) ,
   plansenddate         datetime ,
   productsendmid       varchar(50) ,
   productsenddate      datetime ,
   warehousesendmid     varchar(50) ,
   warehousesenddate    datetime ,
   productmid           varchar(50) ,
   productdate          datetime ,
   productcompletemid   varchar(50) ,
   productcompletedate  datetime ,
   storagemid           varchar(50) ,
   storagedate          datetime ,
   cgoodssendmid        varchar(50) ,
   cgoodssenddate       datetime ,
   completemid          varchar(50) ,
   completedate         datetime ,
   sid                  varchar(50) ,
   senddate             datetime ,
   driver               varchar(50) ,
   sendnote             text ,
   flag                 int ,
   CONSTRAINT pk_ppid PRIMARY KEY (ppid)
) engine='innodb' ;
-- 25、创建生产计划详情表
CREATE TABLE product_plan_details(
   ppdid                int            auto_increment ,
   ppid                 int ,
   cid                  int ,
   name                 varchar(50) ,
   size                 varchar(50) ,
   price                double ,
   num                  int ,
   totalprice           double ,
   CONSTRAINT pk_ppdid PRIMARY KEY(ppdid)
) engine='innodb' ;
-- 26、创建半成品出库记录表
CREATE TABLE ucgoods_output_record(
   uorid                int            auto_increment ,
   ppid                 int ,
   ucid                 int ,
   wid                  int ,
   plid                 int ,
   name                 varchar(50) ,
   size                 varchar(50) ,
   price                double ,
   unit                 int ,
   num                  int ,
   totalprice           double ,
   date                 datetime ,
   CONSTRAINT pk_uorid PRIMARY KEY(uorid)
) engine='innodb' ;
-- 27、创建成品入库记录表
CREATE TABLE cgoods_storage_record(
   csrid                int            auto_increment ,
   ppid                 int ,
   cid                  int ,
   wid                  int ,
   name                 varchar(50) ,
   size                 varchar(50) ,
   price                double ,
   num                  int ,
   totalprice           double ,
   date                 datetime ,
   CONSTRAINT pk_csrid PRIMARY KEY(csrid)
) engine='innodb' ;
-- 28、创建仓库成品表
CREATE TABLE warehouse_cgoods(
   wcid                 int            auto_increment ,
   wid                  int ,
   cid                  int ,
   name                 varchar(50) ,
   size                 varchar(50) ,
   num                  int ,
   CONSTRAINT pk_wcid PRIMARY KEY(wcid)
) engine='innodb' ;
-- 29、创建成品出库记录表
CREATE TABLE cgoods_output_record(
   corid                int            auto_increment ,
   ppid                 int ,
   cid                  int ,
   wid                  int ,
   name                 varchar(50) ,
   size                 varchar(50) ,
   price                double ,
   num                  int ,
   totalprice           double ,
   date                 datetime ,
   CONSTRAINT pk_corid PRIMARY KEY(corid)
) engine='innodb' ;

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
INSERT INTO dept (dname,maxnum,currnum) VALUES ('采购部',10,0) ;
INSERT INTO dept (dname,maxnum,currnum) VALUES ('规划部',10,0) ;
INSERT INTO dept (dname,maxnum,currnum) VALUES ('仓储部',10,0) ;
INSERT INTO dept (dname,maxnum,currnum) VALUES ('生产部',1000,0) ;

-- 增加员工信息
-- 管理部总裁，用户名：mxr-president / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-president',0,1,1,1,'管理部总裁',50000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','upload/emp/nophoto.png','很好的员工','2018-01-10','mxr-raoleilei',1,'2018-01-10 11:11:11') ;

-- 人事部经理，用户名：mxr-human / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-human',1,2,1,1,'人事部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','upload/emp/nophoto.png','很好的员工','2018-01-10','mxr-president',1,'2018-01-10 11:11:11') ;

-- 财务部经理，用户名：mxr-finance / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-finance',1,3,1,1,'财务部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','upload/emp/nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 营销部经理，用户名：mxr-sale / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-sale',1,4,1,1,'营销部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','upload/emp/nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 采购部经理，用户名：mxr-market / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-market',1,5,1,1,'采购部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','upload/emp/nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 规划部经理，用户名：mxr-plan / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-plan',1,6,1,1,'规划部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','upload/emp/nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 仓储部经理，用户名：mxr-warehouse / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-warehouse',1,7,1,1,'仓储部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','upload/emp/nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

-- 生产部经理，用户名：mxr-product / 密码：hello
INSERT INTO emp (eid,lid,did,sex,etid,ename,salary,phone,password,photo,empnote,hiredate,ineid,state,lastdate) VALUES ('mxr-product',1,8,1,1,'生产部经理',10000,'010-110','EAB62A7769F0313F8D69CEBA32F4347E','upload/emp/nophoto.png','很好的员工','2018-01-10','mxr-human',1,'2018-01-10 11:11:11') ;

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
UPDATE dept SET currnum=1 WHERE did=1 ;
UPDATE dept SET currnum=1 WHERE did=2 ;
UPDATE dept SET currnum=1 WHERE did=3 ;
UPDATE dept SET currnum=1 WHERE did=4 ;
UPDATE dept SET currnum=1 WHERE did=5 ;
UPDATE dept SET currnum=1 WHERE did=6 ;
UPDATE dept SET currnum=1 WHERE did=7 ;

-- 增加角色信息
INSERT INTO role(rid,title) VALUES ('dept','【人事部】部门信息管理') ;
INSERT INTO role(rid,title) VALUES ('emp','【人事部】雇员信息管理') ;
INSERT INTO role(rid,title) VALUES ('warehouse','【仓储部】仓库信息管理') ;
INSERT INTO role(rid,title) VALUES ('customer','【营销部】客户信息管理') ;
INSERT INTO role(rid,title) VALUES ('ucgoods','【采购部】半成品信息管理') ;
INSERT INTO role(rid,title) VALUES ('cgoods','【采购部】成品信息管理') ;
INSERT INTO role(rid,title) VALUES ('ucgoodsstorage','【采购部】半成品入库管理') ;
INSERT INTO role(rid,title) VALUES ('ucgoodsstorageaudit','【财务部】半成品入库审核管理') ;
INSERT INTO role(rid,title) VALUES ('ucgoodsmanage','【仓储部】半成品管理') ;
INSERT INTO role(rid,title) VALUES ('plant','【生产部】生产车间管理') ;
INSERT INTO role(rid,title) VALUES ('productplan','【规划部】生产计划管理') ;
INSERT INTO role(rid,title) VALUES ('productplanucgoods','【仓储部】生产计划原材料管理') ;
INSERT INTO role(rid,title) VALUES ('replenishapplication','【仓储部】补货申请管理') ;
INSERT INTO role(rid,title) VALUES ('warehousereplenish','【采购部】仓储补货管理') ;
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


INSERT INTO province (title) VALUES 
 ('其他'), ('北京'), ('重庆'), ('福建'), ('甘肃'), ('广东'),
 ('广西'), ('贵州'), ('海南'), ('河北'), ('黑龙江'), ('河南'),
 ('香港'), ('湖北'), ('湖南'), ('江苏'), ('江西'), ('吉林'),
 ('辽宁'), ('澳门'), ('内蒙古'), ('宁夏'), ('青海'), ('山东'),
 ('上海'), ('山西'), ('陕西'), ('四川'), ('台湾'), ('天津'),
 ('新疆'), ('西藏'), ('云南'), ('浙江'), ('安徽');

INSERT INTO city (pid,title) VALUES 
 (1,'其他'),(35,'合肥'), (35,'安庆'), (35,'蚌埠'), (35,'亳州'), (35,'巢湖'), (35,'滁州'),
 (35,'阜阳'), (35,'贵池'), (35,'淮北'), (35,'淮化'), (35,'淮南'), (35,'黄山'),
 (35,'九华山'), (35,'六安'), (35,'马鞍山'), (35,'宿州'), (35,'铜陵'), (35,'屯溪'),
 (35,'芜湖'), (35,'宣城'), (2,'北京'), (3,'重庆'), (4,'福州'), (4,'福安'),
 (4,'龙岩'), (4,'南平'), (4,'宁德'), (4,'莆田'), (4,'泉州'), (4,'三明'),
 (4,'邵武'), (4,'石狮'), (4,'永安'), (4,'武夷山'), (4,'厦门'), (4,'漳州'),
 (5,'兰州'), (5,'白银'), (5,'定西'), (5,'敦煌'), (5,'甘南'), (5,'金昌');

INSERT INTO city (pid,title) VALUES 
 (5,'酒泉'), (5,'临夏'), (5,'平凉'), (5,'天水'), (5,'武都'), (5,'武威'),
 (5,'西峰'), (5,'张掖'), (6,'广州'), (6,'潮阳'), (6,'潮州'), (6,'澄海'),
 (6,'东莞'), (6,'佛山'), (6,'河源'), (6,'惠州'), (6,'江门'), (6,'揭阳'),
 (6,'开平'), (6,'茂名'), (6,'梅州'), (6,'清远'), (6,'汕头'), (6,'汕尾'),
 (6,'韶关'), (6,'深圳'), (6,'顺德'), (6,'阳江'), (6,'英德'), (6,'云浮'),
 (6,'增城'), (6,'湛江'), (6,'肇庆'), (6,'中山'), (6,'珠海'), (7,'南宁');

INSERT INTO city (pid,title) VALUES 
 (7,'百色'), (7,'北海'), (7,'桂林'), (7,'防城港'), (7,'河池'), (7,'贺州'),
 (7,'柳州'), (7,'钦州'), (7,'梧州'), (7,'玉林'), (8,'贵阳'), (8,'安顺'),
 (8,'毕节'), (8,'都匀'), (8,'凯里'), (8,'六盘水'), (8,'铜仁'), (8,'兴义'),
 (8,'玉屏'), (8,'遵义'), (9,'海口'), (9,'儋县'), (9,'陵水'), (9,'琼海'),
 (9,'三亚'), (9,'五指山'), (9,'万宁'), (10,'石家庄'), (10,'保定'), (10,'北戴河'),
 (10,'沧州'), (10,'承德'), (10,'丰润'), (10,'邯郸'), (10,'衡水'), (10,'廊坊');

INSERT INTO city (pid,title) VALUES 
 (10,'南戴河'), (10,'秦皇岛'), (10,'唐山'), (10,'新城'), (10,'邢台'), (10,'张家口'),
 (11,'哈尔滨'), (11,'北安'), (11,'大庆'), (11,'大兴安岭'), (11,'鹤岗'), (11,'黑河'),
 (11,'佳木斯'), (11,'鸡西'), (11,'牡丹江'), (11,'齐齐哈尔'), (11,'七台河'), (11,'双鸭山'),
 (11,'绥化'), (11,'伊春'), (12,'郑州'), (12,'安阳'), (12,'鹤壁'), (12,'潢川'),
 (12,'焦作'), (12,'济源'), (12,'开封'), (12,'漯河'), (12,'洛阳'), (12,'南阳'), (12,'平顶山'),
 (12,'濮阳'), (12,'三门峡'), (12,'商丘'), (12,'新乡');

INSERT INTO city (pid,title) VALUES 
 (12,'信阳'), (12,'许昌'), (12,'周口'), (12,'驻马店'), (13,'香港'), (13,'九龙'),
 (13,'新界'), (14,'武汉'), (14,'恩施'), (14,'鄂州'), (14,'黄冈'), (14,'黄石'),
 (14,'荆门'), (14,'荆州'), (14,'潜江'), (14,'十堰'), (14,'随州'), (14,'武穴'), (14,'仙桃'),
 (14,'咸宁'), (14,'襄阳'), (14,'襄樊'), (14,'孝感'), (14,'宜昌'), (15,'长沙'), (15,'常德'),
 (15,'郴州'), (15,'衡阳'), (15,'怀化'), (15,'吉首'), (15,'娄底'), (15,'邵阳'), (15,'湘潭'),
 (15,'益阳'), (15,'岳阳'), (15,'永州');

INSERT INTO city (pid,title) VALUES 
 (15,'张家界'), (15,'株洲'), (16,'南京'), (16,'常熟'), (16,'常州'), (16,'海门'),
 (16,'淮安'), (16,'江都'), (16,'江阴'), (16,'昆山'), (16,'连云港'), (16,'南通'),
 (16,'启东'), (16,'沭阳'), (16,'宿迁'), (16,'苏州'), (16,'太仓'), (16,'泰州'),
 (16,'同里'), (16,'无锡'), (16,'徐州'), (16,'盐城'), (16,'扬州'), (16,'宜兴'),
 (16,'仪征'), (16,'张家港'), (16,'镇江'), (16,'周庄'), (17,'南昌'), (17,'抚州'),
 (17,'赣州'), (17,'吉安'), (17,'景德镇'), (17,'井冈山'), (17,'九江'), (17,'庐山');

INSERT INTO city (pid,title) VALUES 
 (17,'萍乡'), (17,'上饶'), (17,'新余'), (17,'宜春'), (17,'鹰潭'), (18,'长春'),
 (18,'白城'), (18,'白山'), (18,'珲春'), (18,'辽源'), (18,'梅河'), (18,'吉林'),
 (18,'四平'), (18,'松原'), (18,'通化'), (18,'延吉'), (19,'沈阳'), (19,'鞍山'),
 (19,'本溪'), (19,'朝阳'), (19,'大连'), (19,'丹东'), (19,'抚顺'), (19,'阜新'),
 (19,'葫芦岛'), (19,'锦州'), (19,'辽阳'), (19,'盘锦'), (19,'铁岭'), (19,'营口'),
 (20,'澳门'), (21,'呼和浩特'), (21,'阿拉善盟'), (21,'包头'), (21,'赤峰'), (21,'东胜');

INSERT INTO city (pid,title) VALUES 
 (21,'海拉尔'), (21,'集宁'), (21,'临河'), (21,'通辽'), (21,'乌海'), (21,'乌兰浩特'),
 (21,'锡林浩特'), (22,'银川'), (22,'固原'), (22,'石嘴山'), (22,'吴忠'), (23,'西宁'),
 (23,'德令哈'), (23,'格尔木'), (23,'共和'), (23,'海东'), (23,'海晏'), (23,'玛沁'),
 (23,'同仁'), (23,'玉树'), (24,'济南'), (24,'滨州'), (24,'兖州'), (24,'德州'),
 (24,'东营'), (24,'菏泽'), (24,'济宁'), (24,'莱芜'), (24,'聊城'), (24,'临沂'),
 (24,'蓬莱'), (24,'青岛'), (24,'曲阜'), (24,'日照'), (24,'泰安');

INSERT INTO city (pid,title) VALUES 
 (24,'潍坊'), (24,'威海'), (24,'烟台'), (24,'枣庄'), (24,'淄博'), (25,'上海'),
 (25,'崇明'), (25,'朱家角'), (26,'太原'), (26,'长治'), (26,'大同'), (26,'候马'),
 (26,'晋城'), (26,'离石'), (26,'临汾'), (26,'宁武'), (26,'朔州'), (26,'忻州'),
 (26,'阳泉'), (26,'榆次'), (26,'运城'), (27,'西安'), (27,'安康'), (27,'宝鸡'),
 (27,'汉中'), (27,'渭南'), (27,'商州'), (27,'绥德'), (27,'铜川'), (27,'咸阳'),
 (27,'延安'), (27,'榆林'), (28,'成都'), (28,'巴中'), (28,'达州'), (28,'德阳');

INSERT INTO city (pid,title) VALUES 
 (28,'都江堰'), (28,'峨眉山'), (28,'涪陵'), (28,'广安'), (28,'广元'), (28,'九寨沟'),
 (28,'康定'), (28,'乐山'), (28,'泸州'), (28,'马尔康'), (28,'绵阳'), (28,'眉山'),
 (28,'南充'), (28,'内江'), (28,'攀枝花'), (28,'遂宁'), (28,'汶川'), (28,'西昌'),
 (28,'雅安'), (28,'宜宾'), (28,'自贡'), (28,'资阳'), (29,'台北'), (29,'基隆'),
 (29,'台南'), (29,'台中'), (30,'天津'), (31,'乌鲁木齐'), (31,'阿克苏'), (31,'阿勒泰'),
 (31,'阿图什'), (31,'博乐'), (31,'昌吉'), (31,'东山'), (31,'哈密');

INSERT INTO city (pid,title) VALUES 
 (31,'和田'), (31,'喀什'), (31,'克拉玛依'), (31,'库车'), (31,'库尔勒'), (31,'奎屯'),
 (31,'石河子'), (31,'塔城'), (31,'吐鲁番'), (31,'伊宁'), (32,'拉萨'), (32,'阿里'),
 (32,'昌都'), (32,'林芝'), (32,'那曲'), (32,'日喀则'), (32,'山南'), (33,'昆明'),
 (33,'大理'), (33,'保山'), (33,'楚雄'), (33,'东川'), (33,'个旧'),
 (33,'景洪'), (33,'开远'), (33,'临沧'), (33,'丽江'), (33,'六库'), (33,'潞西'),
 (33,'曲靖'), (33,'思茅'), (33,'文山'), (33,'西双版纳'), (33,'玉溪');

INSERT INTO city (pid,title) VALUES 
 (33,'中甸'), (33,'昭通'), (34,'杭州'), (34,'安吉'), (34,'慈溪'), (34,'定海'),
 (34,'奉化'), (34,'海盐'), (34,'黄岩'), (34,'湖州'), (34,'嘉兴'), (34,'金华'),
 (34,'临安'), (34,'临海'), (34,'丽水'), (34,'宁波'), (34,'瓯海'), (34,'平湖'),
 (34,'千岛湖'), (34,'衢州'), (34,'江山'), (34,'瑞安'), (34,'绍兴'), (34,'嵊州'),
 (34,'台州'), (34,'温岭'), (34,'温州'), (34,'舟山') ;

 -- 增加客户等级信息表
INSERT INTO citem(title) VALUES ('潜在客户') ;
INSERT INTO citem(title) VALUES ('大单客户') ;
INSERT INTO citem(title) VALUES ('重要客户') ;
INSERT INTO citem(title) VALUES ('网站客户') ;