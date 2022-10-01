# springboot-postgres-k8s
## Caso queira rodar o kubernetes localmente

### Instalar o MiniKube Linux
https://minikube.sigs.k8s.io/docs/start/

### Instalação do  Kubernetes
https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/

### Verificando os  pods
kubectl get po -A

### Build Aplicação
mvn clean install -DskipTests=true

### Build do Dockerfile
docker build -t springboot-postgres-k8s:11 .

### Executar Configurações
### ir para pasta src/main/resources
cd src/main/resources

### Baseado no tutorial
https://www.youtube.com/watch?v=vrjoSsiKZaA&t=80s







