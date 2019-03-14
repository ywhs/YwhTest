# openCV笔记
madlid   机器学习的数据库
## 一.Mat - 基本图像容器


        1.基本上讲 Mat 是一个类，由两个数据部分组成：矩阵头（包含矩阵尺寸，存储方法，存储地址等信息）和一个指向存储所有像素值的矩阵（根据所选存储方法的不同矩阵可以是不同的维数）的指针
        2.CV_[位数][无符号还是有符号][类型前缀]C[通道数]，比如 CV_8UC3 表示使用8位的 unsigned char 型，每个像素由三个元素组成三通道。预先定义的通道数可以多达四个。 
        3.显示的创建Mat对象，对于二维多通道图像，首先要定义其尺寸，即行数和列数。 可以通过Size类传入参数也可以直接通过以下方式传入。
            构造函数：
                Mat mat = new Mat(2,2, CvType.CV_8UC2);
            eye函数，ones函数，zeros函数
                Mat mat1 = Mat.eye(1,1,CvType.CV_8UC2);
                Size size = new Size(1,1);
                Mat mat1 = Mat.eye(size,CvType.CV_8UC2);
                Mat mat2 = Mat.ones(size,CvType.CV_8UC2;
                Mat mat2 = Mat.zeros(size,CvType.CV_8UC2);
        4.Mat.dump函数能查看矩阵，使用 clone() 或者 copyTo() 为一个存在的 Mat 对象创建一个新的信息头。
## 二.转换为灰度值：

   Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2GRAY);    image为Mat对象

## 三.通过surf算法匹配两张图片的相似度


        1.获取源图片，获取目标图片
        2.把两张图片灰度化
        3.创建surf
            SURF surf = SURF.create();
        4.初始化关键点及特征描述矩阵声明
            MatOfKeyPoint matOfKeyPoint1 = new MatOfKeyPoint();
            Mat descMat1 = new Mat();
        5.计算特征关键点,把得到的灰度的图片传入计算
            surf.detect(image1,matOfKeyPoint1);
        6.计算特征描述矩阵
            surf.compute(image1,matOfKeyPoint1,descMat1);
        7.
## 四.keyPoint类 和 Dmatch类
	
        class KeyPoint{        
            Point2f  pt;  //坐标
            float  size; //特征点邻域直径
            float  angle; //特征点的方向，值为[零,三百六十)，负值表示不使用
            float  response;
            int  octave; //特征点所在的图像金字塔的组
            int  class_id; //用于聚类的id
        }
        class Dmatch{
            int queryIdx; //此匹配对应的查询图像的特征描述子索引
            int trainIdx; //此匹配对应的训练(模板)图像的特征描述子索引
            int imgIdx; //训练图像的索引(若有多个)
            float distance; //两个特征向量之间的欧氏距离，越小表明匹配度越高。
        }
## 五：Rect类
	
	public int x;  //左上角x
    public int y;  //左上角y
    public int width;  //截取后的宽度
    public int height;  //截取后的高度


##六：编译opencv
	0.下载Vs Studio 安装 2017
	1.下载opencv https://www.opencv.org/releases.html  安装后会有source文件就是源码
	2.下载opencv_contrib https://github.com/opencv/opencv_contrib/  解压
	3.下载cuda   https://developer.nvidia.com/cuda-downloads?target_os=Windows&target_arch=x86_64&target_version=10&target_type=exelocal  安装
	4.下载Cmake  https://cmake.org/download/   安装
	5.下载Ant http://ant.apache.org/bindownload.cgi
	6.下载python   https://www.python.org/downloads/
	6.编译opencv源码，使用cmake编译
            6.1、配置contrib目录
            6.2、选中选项：WITH_CUBLAS,opencv_enable_nonfree,with_cuda
            6.3、勾选 后  config  配置cuda_root_dir目录 选择cuda的安装路径
            6.4、取消选项：BUILD_DOCS, BUILD_EXAMPLES, CUDA_ATTACH_VS_BUILD_RULE_TO_CUDA_FILE, WITH_TBB, WITH_OPENGL,BUILD_CUDA_STUBS