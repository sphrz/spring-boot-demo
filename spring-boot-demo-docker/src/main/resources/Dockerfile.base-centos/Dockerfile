# 镜像元数据
LABEL name="X.L.Xia CentOS base image" \
      maintainer="X.L.Xia" \
      vendor="X.L.Xia" \
      release="1" \
      summary="A CentOS base image to be used in simple-cloud apps"

# 语言环境变量
ENV LANG='zh_CN.UTF-8' LANGUAGE='zh_CN:zh' LC_ALL='zh_CN.UTF-8' TZ='Asia/Shanghai'

# 安装centos7库依赖
RUN set -eux \
    && yum install -y wget \
    && wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo \
    && wget -O /etc/yum.repos.d/epel-7.repo http://mirrors.aliyun.com/repo/epel-7.repo \
    && wget -O /etc/yum.repos.d/CentOS7-Base-163.repo http://mirrors.163.com/.help/CentOS7-Base-163.repo \
    && yum update -y \
    && yum install -y kde-l10n-Chinese \
    && yum -y reinstall glibc-common \
    && yum clean all \
    && rm -rf /tmp/* \
    && rm -rf /var/cache/yum/*

# 设置语言和时区
RUN set -eux \
    && localedef -c -f UTF-8 -i zh_CN zh_CN.UTF-8 \
    && echo "export LANG=${LANG}" >> /etc/locale.conf \
    && ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo '${TZ}' > /etc/timezone

# 创建devops用户, 默认为root用户(id=0)
RUN set -ex \
    && wget -O /usr/local/bin/tini https://github.com/krallin/tini/releases/download/v0.18.0/tini \
    && groupadd --gid 10001 devops \
    && useradd --uid 10001 --gid devops --shell /bin/bash --create-home devops \
    && chmod -R +x /usr/local/bin \
    && chgrp -R 0 /usr/local \
    && chmod -R g=u /usr/local/bin /opt \
    && sed -i '/^root/c\root:$6$mphzPBXa$3tePoCmOUiRIzOoujeFwjjznQ94LBa6j2k5CHcPiiL2ywVwJ/c8QiqtbKAU2ntbHB2yPcDK2ZDr49GGT1HXkI/:18307:0:99999:7:::' /etc/shadow \
    && sed -i '/^devops/c\devops:$6$n5wOC3GI$Go4jmLorMs9PcJidDtBmH.D4KUoAgg9TTuGRD25/mwztpje0I9jjaENU9xFepnONW/UmAyUX9Fxv52DsKRq5O.:18307:0:99999:7:::' /etc/shadow

# 切换到非root用户
# USER 10001

# 可传递参数来覆盖默认命令
CMD ["bash"]
[root@ecs-7ef181 stage1-os]# ls
Dockerfile.base-alpine  Dockerfile.base-centos  glibc
[root@ecs-7ef181 stage1-os]# cat Dockerfile.base-centos
FROM hub.tech.21cn.com/addons/centos-official:7.7.1908

# 镜像元数据
LABEL name="X.L.Xia CentOS base image" \
      maintainer="X.L.Xia" \
      vendor="X.L.Xia" \
      release="1" \
      summary="A CentOS base image to be used in simple-cloud apps"

# 语言环境变量
ENV LANG='zh_CN.UTF-8' LANGUAGE='zh_CN:zh' LC_ALL='zh_CN.UTF-8' TZ='Asia/Shanghai'

# 安装centos7库依赖
RUN set -eux \
    && yum install -y wget \
    && wget -O /etc/yum.repos.d/CentOS-Base.repo http://mirrors.aliyun.com/repo/Centos-7.repo \
    && wget -O /etc/yum.repos.d/epel-7.repo http://mirrors.aliyun.com/repo/epel-7.repo \
    && wget -O /etc/yum.repos.d/CentOS7-Base-163.repo http://mirrors.163.com/.help/CentOS7-Base-163.repo \
    && yum update -y \
    && yum install -y kde-l10n-Chinese \
    && yum -y reinstall glibc-common \
    && yum clean all \
    && rm -rf /tmp/* \
    && rm -rf /var/cache/yum/*

# 设置语言和时区
RUN set -eux \
    && localedef -c -f UTF-8 -i zh_CN zh_CN.UTF-8 \
    && echo "export LANG=${LANG}" >> /etc/locale.conf \
    && ln -snf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo '${TZ}' > /etc/timezone

# 创建devops用户, 默认为root用户(id=0)
RUN set -ex \
    && wget -O /usr/local/bin/tini https://github.com/krallin/tini/releases/download/v0.18.0/tini \
    && groupadd --gid 10001 devops \
    && useradd --uid 10001 --gid devops --shell /bin/bash --create-home devops \
    && chmod -R +x /usr/local/bin \
    && chgrp -R 0 /usr/local \
    && chmod -R g=u /usr/local/bin /opt \
    && sed -i '/^root/c\root:$6$mphzPBXa$3tePoCmOUiRIzOoujeFwjjznQ94LBa6j2k5CHcPiiL2ywVwJ/c8QiqtbKAU2ntbHB2yPcDK2ZDr49GGT1HXkI/:18307:0:99999:7:::' /etc/shadow \
    && sed -i '/^devops/c\devops:$6$n5wOC3GI$Go4jmLorMs9PcJidDtBmH.D4KUoAgg9TTuGRD25/mwztpje0I9jjaENU9xFepnONW/UmAyUX9Fxv52DsKRq5O.:18307:0:99999:7:::' /etc/shadow

# 切换到非root用户
# USER 10001

# 可传递参数来覆盖默认命令
CMD ["bash"]
