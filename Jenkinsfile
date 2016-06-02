node {
  stage 'Git checkout'
  echo 'Checking out git repository'
  git url: 'https://github.com/mcanoy/ticket-monster.git', branch: 'openshift-pipe'

  stage 'Build Project With Maven'
  echo 'Building Project'
  def mvnHome = tool 'M3'
  sh "${mvnHome}/bin/mvn package"

}
