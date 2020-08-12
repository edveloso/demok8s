
minikube delete
minikube start --insecure-registry="dev-harbor.ctn.prevnet"


docker build -t teste/demo:3.0 --build-args VERSION_APP_ARG=3.0 .
docker run -dp 8181:8181 teste/demo:3.0

docker login dev-harbor.ctn.prevnet
docker commit teste/demo:3.0
docker tag teste/demo:3.0 dev-harbor.np-ctn.prevnet/teste/demo:3.0
docker push dev-harbor.np-ctn.prevnet/teste/demo:3.0

kubectl  create secret docker-registry regcred --docker-server=https://dev-harbor.np-ctn.prevnet/ --docker-username=ednilson.veloso --docker-password=MINHA-SENHA-MAROTA --docker-email=ednilson.veloso@dataprev.gov.br

#No deploy
******************************************************************
     spec:
      containers:
      - image: dev-harbor.np-ctn.prevnet/teste/demo:3.0
        imagePullPolicy: IfNotPresent
        name: demo
        resources: {}
      imagePullSecrets:
      - name: regcred    
******************************************************************

kubectl create deployment demo --image=teste/demo:3.0 --dry-run -o yaml > deploy.yml
kubectl apply -f deploy.yml

kubectl expose deployment demo --type=NodePort --port=8080   --name=demo-svc --dry-run -o yaml > service.yml
cat service.yml
kubectl apply -f service.yml

kubectl get services
minikube service demo-svc --url






