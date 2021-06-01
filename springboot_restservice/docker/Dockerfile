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
