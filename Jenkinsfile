node {
  stage 'Git checkout'
  echo 'Checking out git repository'
  git url: 'https://github.com/mcanoy/ticket-monster.git', branch: 'openshift-pipe'

  stage 'Build Project With Maven'
  echo 'Building Project'
  def mvnHome = tool 'M3'
  sh "${mvnHome}/bin/mvn -f demo/pom.xml clean package -Prelease-dist"

  stage 'Run Arquillian Tests'

  sh 'pwd > pwd.current'
  env.WORKSPACE = readFile('pwd.current')
  env.JBOSS_HOME = "${env.WORKSPACE}/jboss/jboss-eap-6.4"

  echo "JBOSS_HOME" $JBOSS_HOME

  if [ ! -d "$JBOSS_HOME" ]; then
    rm -rf jboss
    mkdir jboss
    cd jboss
    curl -o jboss.tar -0 http://nexus-infra-tools.rhel-cdk.10.1.2.2.xip.io/content/repositories/releases/org/jboss/eap/6.4.0/eap-6.4.0.tar
    tar -xvf jboss.tar
  fi

  def mvnHome = tool 'M3'
  ${mvnHome}/bin/mvn -f demo/pom.xml test -Parq-jbossas-managed
'''
}
