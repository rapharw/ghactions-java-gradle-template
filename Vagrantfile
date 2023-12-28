$script = <<-SCRIPT
  sudo apt-get update
  sudo apt-get install docker -y
  sudo apt-get install docker-compose -y
  sudo chmod 666 /var/run/docker.sock
  sudo grep docker /etc/group
  sudo usermod -aG docker $USER
SCRIPT


Vagrant.configure("2") do |config|
  config.vm.box = "hashicorp/bionic64"

  # Configuração de recursos
  config.vm.provider "virtualbox" do |vb|
    vb.memory = 4096  # 4GB de memória (em MB)
    vb.cpus = 2       # 2 CPUs
  end

  # Redirecionamento de portas
  config.vm.network "forwarded_port", guest: 8080, host: 8080

  # Sincronizar pastas
  config.vm.synced_folder "./", "/vagrant"

  # Scripts
  config.vm.provision "shell", inline: $script

end