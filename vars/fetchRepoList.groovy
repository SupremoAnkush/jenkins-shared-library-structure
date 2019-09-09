def call(){
    def proc= "curl -u admin:admin123 http://18.224.155.110:8081/nexus/service/local/repositories".execute()
    Thread.start { System.err << proc.err }
    proc.waitFor()
    }
