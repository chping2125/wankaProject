/**
  * 动画的封装：变速运动、匀速运动、鼠标事件在box的位置
  * 	target对象的属性：width、height、left、top、opacity
  *
  * 	说明：使用前，必须引入Util.js工具类
  * 	
  * Created by Administrator on 2016/8/16.
  **/
var Animation ={
    /**
     * [宽高大小和left,top的位置以及透明色减速柔和变化（变速运动）]
     * @param  {[Element]}   element [需要添加动画的节点]
     * @param  {[Object]}    target  [left/top/width/height/opacity的对象和参数]
     * @param  {Function}    fn      [回调函数]
     */
    transfrom:function(element,target){
        //1.取消同一个节点的上一次周期函数，防止对于一个节点多个周期函数出现
        clearInterval(element.timer);
        //2.绑定周期函数
        element.timer = setInterval(function(){
            //3.循环target内的所有属性并设置
            var current = Math.round(parseFloat(WindowUtil.getScrollTop()));
            //防止current取值后转为NaN的特殊情况
            if(!current){
                current = 0;
            }
                //4.（目标值-当前值)/自定义倍数  设置变化速度
                var speed = (target.scrollTop-current)/15;
                //5.针对速度值进行取整操作，主要是针对小数
                speed = speed>0 ? Math.ceil(speed):Math.floor(speed);
                //6.判断当前值是否达到目标值
                if(current == target.scrollTop){
                     element.scrollTop = 0;
                     clearInterval(element.timer);
                }else{
                    element.scrollTop = current +speed;
                }

        },1);
    },
    transform2:function(element,target,speed,fn){
		clearInterval(element.timer);
		element.timer=setInterval(function(){
			var isComplete =true;
			for(var attr in target){
				if(attr == 'opacity'){
                    var current = Math.round(parseFloat(DomUtil.getStyle(element,attr))*100);
                }else{
                    var current = Math.round(parseFloat(DomUtil.getStyle(element,attr)));
                }
                if(!current){
                    current=0;
                }
                if(speed>0){
                     if(current+speed >=target[attr]){
                        element.style[attr] = target[attr] +'px';
                    }else{
                        isComplete = false;
                        if(attr == 'opacity'){
                            element.style.opacity = (current + speed)/100;
                            element.style.filter = 'alpha(opacity:'+parseInt(current +speed)+')';
                        }else{
                            element.style[attr] = current+speed +'px';
                        }
                    }
                }else{
                     if(current-speed <=target[attr]){
                        element.style[attr] = target[attr] +'px';
                    }else{
                        isComplete = false;
                        if(attr == 'opacity'){
                            element.style.opacity = (current + speed)/100;
                            element.style.filter = 'alpha(opacity:'+parseInt(current +speed)+')';
                        }else{
                            element.style[attr] = current+speed +'px';
                        }
                    }
                }
                if(isComplete){
                    clearInterval(element.timer);
                	if(fn){
                		fn();
                	}
                }

			}
		});
	}
};