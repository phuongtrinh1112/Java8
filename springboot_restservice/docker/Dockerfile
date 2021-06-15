FROM <base>

ARG JAR_FILE=target/rest-service-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

ENV JAVA_OPTS="-Xmx512m -Xms128m"
ENV JVM_OPTS=""
RUN echo "java $JMX_OPTS $JAVA_OPTS $JVM_OPTS -jar /app.jar"
CMD java $JMX_OPTS $JVM_OPTS $JAVA_OPTS -jar /app.jar



==========================================


//    @Test
//    public void testResponsePost(){
//        String url = "http://localhost:" + String.valueOf(port) + "/associates/add";
//        CloseableHttpClient client = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//        try {
//            httpPost.setHeader("Content-Type", "application/json");
//            httpPost.setEntity(new StringEntity("{\n" +
//                    "\t\"code\":\"FORTNA123\",\n" +
//                    "\t\"name\":\"Phuong Trinh\"\n" +
//                    "}"));
//            CloseableHttpResponse response = client.execute(httpPost);
//            HttpEntity entity = response.getEntity();
//            String result = EntityUtils.toString(entity);
//            System.out.println(result);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            client.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

=====================================================================

{
    "header": {
        "message_session_id": "79485943881449476",
        "message_type": "InboundContentDownload",
        "version": "1.0",
        "message_id": "79485943881449476",
        "timestamp": "2021-04-20T01:02:05.665Z",
        "unix_timestamp": "1618880525665"
    },
    "data": {
        "inbound-contents": [
            {
                "inbound_number": "T6112",
                "inbound_type": "TOTE",
                "contents": [
                    {
                        "sku": "SKU061",
                        "quantity": 61,
                        "metadata": {
                            "store": "S61",
                            "destination": "D61"
                        }
                    },
                    {
                        "sku": "SKU062",
                        "quantity": 62,
                        "metadata": {
                            "store": "S61",
                            "destination": "D61"
                        }
                    }
                ],
                "metadata": {
                    "attributes": "Numberware"
                }
            },
            {
                "inbound_number": "T6212",
                "inbound_type": "TOTE",
                "contents": [
                    {
                        "sku": "SKU062",
                        "quantity": 63,
                        "metadata": {
                            "store": "S61"
                        }
                    }
                ],
                "metadata": {
                    "attributes": "Numberware"
                }
            }                                    
        ]
    }
}


===========================================================
FROM docker.fortna.com/wes/app-jdk8-dev:10

 Install Maven
RUN apk add --no-cache curl tar bash
ARG MAVEN_VERSION=3.6.3
ARG USER_HOME_DIR="/root"
RUN mkdir -p /usr/share/maven && \
curl -fsSL http://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 && \
ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
# speed up Maven JVM a bit
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
ENTRYPOINT ["/usr/bin/mvn"]
# ----
# Install project dependencies and keep sources
# make source folder
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
# copy folder
COPY example/* ./example/
COPY fortna-serenity-extension/* ./fortna-serenity-extension/

# build the app and download dependencies only when these are new
RUN --mount=type=cache,target=/root/.m2  mvn clean package -Dmaven.test.skip
# install maven dependency packages (keep in image)
RUN cd fortna-serenity-extension/
COPY pom.xml /usr/src/app
RUN mvn -T 1C install && rm -rf target
# copy other source files (keep in image)
COPY src /usr/src/app/src


RUN cd ../example/
CMD ["mvn", "install"]





#copy pom
RUN 'cd fortna-serenity-extension'
COPY pom.xml .
    
#copy source
COPY src ./src
RUN cd ../
# build the app and download dependencies only when these are new (thanks to the cache)
# RUN --mount=type=cache,target=/root/.m2  mvn clean package -Dmaven.test.skip
VOLUME ["/home/ptrinh/.m2", "/root/.m2"]

# split the built app into multiple layers to improve layer rebuild
RUN mkdir -p target/docker-packaging && cd target/docker-packaging && jar -xf ../my-app*.jar

########JRE run stage########
FROM docker.fortna.com/wes/app-jdk8-dev:10
WORKDIR /app

#copy built app layer by layer
ARG DOCKER_PACKAGING_DIR=/app/target/docker-packaging
COPY --from=maven_build ${DOCKER_PACKAGING_DIR}/BOOT-INF/lib /app/lib
COPY --from=maven_build ${DOCKER_PACKAGING_DIR}/BOOT-INF/classes /app/classes
COPY --from=maven_build ${DOCKER_PACKAGING_DIR}/META-INF /app/META-INF

#run the app
RUN cd ../example/
CMD ["mvn", "install"]


=====================================================================================

1. Send msg Store to Location
2. Send msg Inbound Case Content
	Athena testing note: https://fortna.atlassian.net/wiki/spaces/WQC/pages/666730581/Athena+s+Testing+Notes
	2.1 Configured on Athena side:
		http://10.240.26.150:9000/#/stacks
		-appopts -Devent.processors.hostOrder.processor.0=com.fortna.athena.example.pts.PtsSendOrderStatusProcessor
		-appopts -Devent.processors.container.processor.1=com.fortna.athena.example.pts.PtsSendContainerStatusProcessor
		-appopts -Devent.processors.container.processor.2=com.fortna.athena.event.processors.SendLPNDestinationProcessor 
		-appopts -Dwesconductor.receiver.transform=com.fortna.athena.dfbehavior.pts.Receiver2PTSWorkOrderTransformation
	2.2 Restart Athena pointainer stack( or update stack)
	
	2.3 Send message inbound content from host to Athena
	- API URL: http://{{base_url}}:8088/api/inbound-contents/
	- Content:
	
	{
		"header":{
			"message_session_id":"${message_session_id}",     					---> random number
			"message_type":"${message_type}",           						---> InboundContentDownload
			"version":"${version}",												---> 1.0
			"message_id":"${message_id}",										---> random number
			"timestamp":"${timestamp}",											---> random Date Time
			"unix_timestamp":"${unix_timestamp}"
		},
		"data":{
			"inbound-contents":[
				{
					"inbound_number":"${inbound_number}",     					---> format T + 8-length number          T123        
					"inbound_type":"${inbound_type}",     					    ---> random number
					"contents":[
						{
							"sku":"${sku}",     					            ---> random value
							"quantity":"${quantity}",							---> random number
							"metadata":{
									"store":"${metadata1_store}",				---> select * from PTS.STORE;
									"destination":"${metadata1_destination}"	---> select select * from CUBBY_STORE_XREF WHERE;
							}
						}
					],
					"metadata":{
						"attributes":"${metadata2_attributes}"					---> random value
					}
				}
			]
		}
	}
	
	
	            "task_id":80228874047246338,
            "group_task_id":80228874052489217,
            "sku":"SKU001",
            "requested_qty":1,
            "metadata":{
               "destination":"D61",
               "store":"S61"
            }
         },
         {
            "task_id":80228874050392066,
            "group_task_id":80228874052489217,
            "sku":"SKU002",
            "requested_qty":20,
            "metadata":{
               "destination":"D62",
               "store":"S62"
            }
         }
      ],
      "work_area":"PTS",
      "metadata":{
         
      }
   }
}
