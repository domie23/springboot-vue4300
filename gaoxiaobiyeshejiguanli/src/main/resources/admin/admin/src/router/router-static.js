import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dafenzhongxin from '@/views/modules/dafenzhongxin/list'
    import dictionary from '@/views/modules/dictionary/list'
    import ketishenqing from '@/views/modules/ketishenqing/list'
    import ketixuanze from '@/views/modules/ketixuanze/list'
    import news from '@/views/modules/news/list'
    import wenjianzhongxin from '@/views/modules/wenjianzhongxin/list'
    import wenjianzhongxinAdd from '@/views/modules/wenjianzhongxin/add-or-update'
    import wodeketi from '@/views/modules/wodeketi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import dictionaryBanji from '@/views/modules/dictionaryBanji/list'
    import dictionaryKetishenqingYesno from '@/views/modules/dictionaryKetishenqingYesno/list'
    import dictionaryKetixuanze from '@/views/modules/dictionaryKetixuanze/list'
    import dictionaryKetixuanzeYesno from '@/views/modules/dictionaryKetixuanzeYesno/list'
    import dictionaryLaiyuan from '@/views/modules/dictionaryLaiyuan/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryWenjianzhongxinYesno from '@/views/modules/dictionaryWenjianzhongxinYesno/list'
    import dictionaryWodeketi from '@/views/modules/dictionaryWodeketi/list'
    import dictionaryZhuanye from '@/views/modules/dictionaryZhuanye/list'
    import dabianshenqing from '@/views/modules/dabianshenqing/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryBanji',
        name: '班级',
        component: dictionaryBanji
    }
    ,{
        path: '/dictionaryKetishenqingYesno',
        name: '审核结果',
        component: dictionaryKetishenqingYesno
    }
	,{
	    path: '/wenjianzhongxinAdd',
	    name: '文件上传',
	    component: wenjianzhongxinAdd
	}
	,{
	    path: '/dabianshenqing',
	    name: '答辩申请',
	    component: dabianshenqing
	}
    ,{
        path: '/dictionaryKetixuanze',
        name: '课题类型',
        component: dictionaryKetixuanze
    }
    ,{
        path: '/dictionaryKetixuanzeYesno',
        name: '审核结果',
        component: dictionaryKetixuanzeYesno
    }
    ,{
        path: '/dictionaryLaiyuan',
        name: '课题来源',
        component: dictionaryLaiyuan
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryWenjianzhongxinYesno',
        name: '审核结果',
        component: dictionaryWenjianzhongxinYesno
    }
    ,{
        path: '/dictionaryWodeketi',
        name: '课题状态',
        component: dictionaryWodeketi
    }
    ,{
        path: '/dictionaryZhuanye',
        name: '专业',
        component: dictionaryZhuanye
    }


    ,{
        path: '/dafenzhongxin',
        name: '打分记录',
        component: dafenzhongxin
      }
    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/ketishenqing',
        name: '课题申请',
        component: ketishenqing
      }
    ,{
        path: '/ketixuanze',
        name: '课题选择',
        component: ketixuanze
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/wenjianzhongxin',
        name: '文件中心',
        component: wenjianzhongxin
      }
    ,{
        path: '/wodeketi',
        name: '我的课题',
        component: wodeketi
      }
    ,{
        path: '/yonghu',
        name: '学生',
        component: yonghu
      }
    ,{
        path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
