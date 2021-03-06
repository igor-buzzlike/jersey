/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2010-2011 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.glassfish.jersey.tests.spring.springmanaged;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.glassfish.jersey.tests.spring.Item;
import org.glassfish.jersey.tests.spring.Item2;


/**
 * TODO: DESCRIBE ME<br>
 * Created on: Apr 10, 2008<br>
 * 
 * @author <a href="mailto:martin.grotzke@freiheit.com">Martin Grotzke</a>
 * @version $Id$
 */
public class SpringManagedPerRequestResourceBase {
    
    public SpringManagedPerRequestResourceBase() {
    }
    
    private Item _singletonItem;
    private Item2 _prototypeItem;
    
    private int _count;
    
    protected Item getSingletonItemInstance() {
        return _singletonItem;
    }
    
    protected Item2 getPrototypeItemInstance() {
        return _prototypeItem;
    }

    @GET
    @Path( "singletonitem" )
    @Produces( "application/xml" )
    public Item getSingletonItem() {
        return getSingletonItemInstance();
    }

    @PUT
    @Path( "singletonitem/value/{value}" )
    public void setSingletonItemValue( @PathParam( "value" ) String value ) {
        getSingletonItemInstance().setValue( value );
    }

    @GET
    @Path( "prototypeitem" )
    @Produces( "application/xml" )
    public Item2 getPrototypeItem() {
        return getPrototypeItemInstance();
    }

    @PUT
    @Path( "prototypeitem/value/{value}" )
    public void setPrototypeItemValue( @PathParam( "value" ) String value ) {
        getPrototypeItemInstance().setValue( value );
    }
    
    @GET
    @Path( "count" )
    @Produces("text/plain")
    public String getCount() {
        return String.valueOf( _count );
    }
    
    @POST
    @Path( "count" )
    public void updateCount() {
        _count++;
    }

    /**
     * @param prototypeItem the prototypeItem to set
     * @author Martin Grotzke
     */
    public void setPrototypeItem( Item2 prototypeItem ) {
        _prototypeItem = prototypeItem;
    }

    /**
     * @param singletonItem the singletonItem to set
     * @author Martin Grotzke
     */
    public void setSingletonItem( Item singletonItem ) {
        _singletonItem = singletonItem;
    }
    
}
