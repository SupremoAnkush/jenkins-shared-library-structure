def call(){
    curl -H "Content-Type: application/json" -d @repo.json -u admin:admin123 'http://18.224.155.110:8081/nexus/service/local/repositories';
    "repositories": {
      "repository": [
        {
          "create": true,
          "repository_name": "Tycoon_8872",
          "repository_type": "proxy",
          "repository_policy": "RELEASE",
          "repository_provider": "maven2",
        }
      ]
    }
    }
