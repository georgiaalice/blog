$script = <<SCRIPT
    locale-gen en_GB.UTF-8
    add-apt-repository ppa:webupd8team/java
    apt-get --assume-yes update
    apt-get --assume-yes dist-upgrade
    apt-get --assume-yes install oracle-java8-installer oracle-java8-set-default

    echo "export JAVA_HOME=/usr/lib/jvm/java-8-oracle" >> /home/vagrant/.bashrc
    echo "export PATH=$PATH:/usr/local/mvn/bin" >> /home/vagrant/.bashrc
SCRIPT

Vagrant.configure(2) do |config|
    config.vm.box = "ubuntu/trusty64"
    config.vm.network "private_network", ip: "192.168.33.27"
    config.vm.provision "shell", inline: $script
end
