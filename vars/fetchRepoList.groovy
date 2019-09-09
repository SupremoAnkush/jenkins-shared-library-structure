def call(){
    curl -u ${admin}:${admin123} -X GET 'http://18.224.155.110:8081/nexus/service/local/repositories'
    }
