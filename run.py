# -!- coding: utf-8 -!-
import os


def run(cmd):
    try:
        os.system(cmd)
    except:
        pass
    
if __name__ == '__main__':
    run("docker stop java-wx")
    run("docker rm java-wx")
    run("docker rmi wx")
    run("docker build -f wx.dockerfile -t wx .")
    run("docker run  -d --name java-wx -p 80:80 wx")

