/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.catalina.startup;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Test Mock with wrong Annotation!
 *
 * @author Peter Rossbach
 * @version $Id: DuplicateMappingParamFilter.java 1198558 2011-11-06 21:12:12Z kkolinko $
 *
 */
@WebFilter(value = "/param", filterName="paramDFilter",
        urlPatterns = { "/param1" , "/param2" })
public class DuplicateMappingParamFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // NO-OP
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        // destroy
    }
}

