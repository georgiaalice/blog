# base-java
This is the base of a blogging website written in Java (and Spark)

## Setting Up Locally

Our end goal is to have our very own blog website that we can write posts on. The first step to having a website running on the Internet is to get one running on your local machine. No one will be able to access it, but at least you'll know it works.

To get the blog up and running locally we'll first need to grab a copy of the base code from Github. Here's [a link](https://github.com/CodeGuild-co/base-java/archive/master.zip). Download this zip file and unzip it onto the Desktop.

The unzipped folder is called `base-java-master` that's not particularly descriptive, change it to something nicer. I called mine `blog`.

We now have the code but we can't run it because we haven't installed the software dependencies. Let's do that. Open a `Konsole` window and type the following commands (don't type the `$` symbol, that's to show you that we're looking at a `Konsole` command line):

    $ sudo add-apt-repository ppa:webupd8team/java
    $ sudo apt-get --assume-yes update
    $ sudo apt-get --assume-yes install oracle-java8-installer oracle-java8-set-default

You'll have to answer some questions when you install these things. Just say yes.

That installed the Java goodness we need for our website. We now need to tell the computer where to look for that goodness:

    $ echo "export JAVA_HOME=/usr/lib/jvm/java-8-oracle" >> ~/.bashrc

Now we have Java, we need to get another tool, called Maven. This is as easy as:

    $ wget http://www.mirrorservice.org/sites/ftp.apache.org/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
    $ tar -xvf apache-maven-3.3.9-bin.tar.gz
    $ sudo mv apache-maven-3.3.9 /usr/local/mvn
    $ rm apache-maven-3.3.9-bin.tar.gz
    $ echo 'export PATH=$PATH:/usr/local/mvn/bin' >> ~/.bashrc

Next, close your `Konsole` window and open it back up again. The things we installed aren't picked up by the command line until we've restarted it.

We're now ready to go! Let's compile our Java code:

    $ cd Desktop/blog
    $ mvn install
    $ mvn compile

And then run the compiled Java code:

    $ java -cp target/classes:target/dependency/* Main

You should now be able to open up a browser and visit http://localhost:3000 to see your blog. When you make changes to the files, refresh the page to see the website change.

## Saving Your Work

Once you've made some changes you'll want to save them. As well as saving them to your USB stick, you should save your projects in "the cloud". More accurately, you should save your code in a version control system. For this project we'll use `git`, and GitHub.

First, download `git`:

    $ sudo apt-get install git

Then set up `git` to use your name and email address:

    $ git config --global user.name "YOUR NAME"
    $ git config --global user.email "YOUR EMAIL ADDRESS"

Now visit [GitHub](https://github.com) and create an account (it's free).

In GitHub create a new repository by clicking the plus symbol in top-right of the page. Don't check the "Initialize this repository with a README" checkbox.

Let's save our local code to this new GitHub repository:

    $ git init
    $ git add .
    $ git commit -m "First commit"
    $ git remote add origin https://github.com/USERNAME/REPO.git
    $ git push -u origin master

You'll have to change `USERNAME` and `REPO` to match your username and repository name.

You're all done!

Anytime you want to save future changes you'll only need to run:

    $ git add .
    $ git commit -m "MESSAGE DESCRIBING YOUR CHANGES"
    $ git push origin master

## Getting Online

To get this base blog online you'll need to:

1. Get Billy to give you your own copy of this repo
    - You probably already have this
    - You'll have picked a unique domain name too
2. Signup to [Heroku](heroku.com)
3. Create an app on Heroku
    - Use the European region when asked
4. Connect your Heroku account to your Github account
5. Connect your Heroku app to your Github repo
6. Enable automatic deploys
7. Make a change to your repo (using the Github editor)
8. Visit your Heroku app's settings and add a custom domain
    - add your personal CodeGuild domain
    - e.g. `wm.codeguild.co`
8. Visit your domain and see your blog!


## Adding Posts

1. Create a file for your new post in `src/main/resources/spark/template/freemarker`
2. Add a reference to your new post in the nav bar and the index page

It's easy, but boring. You should try using Java (and Spark) to automate these steps (be lazy!).
