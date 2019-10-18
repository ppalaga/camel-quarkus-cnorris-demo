// camel-k: secret=cnorris-secret trait=knative-service.min-scale=0
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
package org.acme.rest.json;

import org.apache.camel.builder.RouteBuilder;

/**
 * Camel route definitions.
 */
public class Routes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("platform-http:/cnorris")
            .setBody(constant("Do not laugh at Chuck Norris!"))
            ;
    }

/*
Step 1: random joke in JSON format
            .setHeader("Accept-Encoding").constant("identity")
            .to("netty-http:http://api.icndb.com/jokes/random?exclude=[explicit]")
Step 2: parse JSON, extract the text of the joke
            .unmarshal().json()
            .setBody().simple("${body[value][joke]}")
            .setHeader("Content-Type").constant("text/plain")
Step 3: forward to twitter
            .to("twitter-timeline://user")

Step 4: Do it periodically instead of per rest endpoint request
            from("timer:tick?period=3s")

Debug, if something goes wrong:
            .log("log:cnorris")

*/
}
