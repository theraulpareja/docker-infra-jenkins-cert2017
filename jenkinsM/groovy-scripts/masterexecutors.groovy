//Want to reduce the amount of executors on master to only 1
//because it may be needed to run sed jobs with DSL

import jenkins.model.*
Jenkins.instance.setNumExecutors(1)
