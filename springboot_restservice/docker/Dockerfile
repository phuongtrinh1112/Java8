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