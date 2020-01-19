package dao.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Page <T>{
    int curentPage = 1;//当前页
    int onePageCount = 7;//每页总数
    
    int totoPageCount;//总页数
    String url;//访问地址
    String parm;//参数
    List <T> datas; //所有数据
    List <T> pageDatas;//当页数据
    
    public Page() {
    }

    public Page(List<T> datas,String url,String parm) {
        this.datas = datas;
        this.url = url;
        this.parm = parm;
        if(datas.size()%this.onePageCount==0) {
        	totoPageCount = datas.size()/this.onePageCount;
        }else {
        	totoPageCount = datas.size()/this.onePageCount+1;
        }
        
        
    }
    

    public List<T> getPageDatas(int pageNumber){
        pageDatas = new ArrayList<>();
        if(pageNumber>datas.size()/onePageCount+1){
            pageNumber = datas.size()/onePageCount+1;
        }
        if(pageNumber<1){
            pageNumber = 1;
        }
        for(int i=0;i<onePageCount;i++){
            if((pageNumber-1)*onePageCount+i>=datas.size()){
                break;
            }
            pageDatas.add(datas.get((pageNumber-1)*onePageCount+i));
        }
        return pageDatas;
    }
    
    public Map<String,String> getPagMap(int pageNumber){
    	
        Map <String,String> pageBuffer = new HashMap<String, String>();

        if(datas.size()<=0) {
        	pageBuffer.put("查询不到有关记录",url+"?page="+"1"+parm);
        	return pageBuffer;
        }
        if(datas.size()/onePageCount<=1) {
        	return pageBuffer;
        }

        if(pageNumber>=2) {
            int before = pageNumber-1;
            pageBuffer.put("上一页",url+"?page="+before+parm);
        }
        for(int i=1;i<=datas.size()/onePageCount+1;i++){
            pageBuffer.put(i+"",url+"?page="+i+parm);
        }
        if(pageNumber<=datas.size()/onePageCount) {
            int next = pageNumber+1;
            pageBuffer.put("下一页",url+"?page="+next+parm);
        }
        if(pageNumber>=2) {
        	pageBuffer.put("首页",url+"?page="+1+parm);
        }
        if(pageNumber<=datas.size()/onePageCount) {
            pageBuffer.put("尾页",url+"?page="+(datas.size()/onePageCount+1)+parm);
        }
        return pageBuffer;

    }

    public int getCurentPage() {
        return curentPage;
    }

    public void setCurentPage(int curentPage) {
        this.curentPage = curentPage;
    }


    public int getOnePageCount() {
		return onePageCount;
	}

	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}

	public int getTotoPageCount() {
		return totoPageCount;
	}


	public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
