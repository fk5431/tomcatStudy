/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.tomcat.jdbc.test;

import org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer;

import java.sql.Connection;
import java.sql.Statement;

public class StatementFinalizerTest extends DefaultTestCase {

    public StatementFinalizerTest(String name) {
        super(name);
    }

    public void testStatementFinalization() throws Exception {
        this.init();
        datasource.setJdbcInterceptors(StatementFinalizer.class.getName());
        Connection con = datasource.getConnection();
        Statement st = con.createStatement();
        assertFalse("Statement should not be closed.",st.isClosed());
        con.close();
        assertTrue("Statement should be closed.",st.isClosed());
    }

}
