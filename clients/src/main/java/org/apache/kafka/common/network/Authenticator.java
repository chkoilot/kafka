/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kafka.common.network;

/*
 * Authentication for Channel
 */

import java.io.IOException;
import com.sun.security.auth.UserPrincipal;


public interface Authenticator {

    /**
     * Closes this channel
     *
     * @throws IOException if any I/O error occurs
     */
    void close() throws IOException;

    /**
     *
     * @throws IOException
     */
    void init() throws IOException;

    /**
     * Returns UserPrincipal after authentication is established
     */
    UserPrincipal userPrincipal() throws IOException;


    /**
     * Does authentication and returns SelectionKey.OP if further communication needed
     */
    int authenticate(boolean read, boolean write) throws IOException;

    /**
     * returns true if authentication is complete otherwise returns false;
     */

    boolean isComplete();

}
