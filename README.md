# Sistema de Gestão Escolar


<h2>Install Docker CE on Ubuntu 18.04 - 20.04<h2>
  
  <h3>Uninstall old versions</h3>
  sudo apt-get remove docker docker-engine docker.io containerd runc
  
  <h3>Updating all your software</h3>
  sudo apt-get update && sudo apt-get upgrade -y
  
  <h3>Set up the repository</h3>
  sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common
  
  curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
  
  sudo apt-key fingerprint 0EBFCD88
  
  <h3>Use the following command to set up the stable repository:</h3>
  sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
  
  
  <h3>Install Docker CE</h3>
  sudo apt-get update
  sudo apt-get install docker-ce docker-ce-cli containerd.io
  
  <h3>Create a user</h3>
  adduser user

  usermod -aG docker user
  
  systemctl restart docker
  
  <h3>Configure Docker to start on boot</h3>
  systemctl enable docker
  
  <h3>Install Docker Compose</h3>
  sudo curl -L https://github.com/docker/compose/releases/download/1.29.2/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
  
  sudo chmod +x /usr/local/bin/docker-compose
  
  docker-compose --version
  
<h2> docker-compose.yml</h2>
  
O arquivo docker-compose.yml está na raiz deste projeto.
