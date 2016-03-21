package com.king.entity;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class TestUsers {
	
	
	@Test
	public void testSchemaExport(){
		//创建配置对象
		Configuration config = new Configuration().configure();
		
		//创建schemaExport对象
		SchemaExport export = new SchemaExport(config);
		
		export.execute(true, true, false, false);
	}

}
