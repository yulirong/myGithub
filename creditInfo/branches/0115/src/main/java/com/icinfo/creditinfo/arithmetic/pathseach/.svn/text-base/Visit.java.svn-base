package com.icinfo.creditinfo.arithmetic.pathseach;

import java.util.List;
import java.util.Set;

import com.icinfo.creditinfo.bean.analy.cranalyentrelation.CrAnalyEntRelation;

public interface Visit {
	/** 
	 * 描述: 初始化数据
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @return 
	 */
	public List<NodeRoad> init(List<CrAnalyEntRelation> relationList);
	
	/** 
	 * 描述: 判断所有路径中是否有以begin节点为起点的基本路径
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param begin
	 * @param end
	 * @param roads
	 * @return 
	 */
	
	public boolean existBegin(String begin,String end, List<NodeRoad> roads);
	
	/** 
	 * 判断所有路径中是否有以end节点为终点的基本路径
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param end
	 * @param begin
	 * @param roads
	 * @return 
	 */
	public boolean existEnd(String end,String begin, List<NodeRoad> roads);
	
	/** 
	 * 判断所有路径中是否有以begin节点为起点的基本路径
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param roads
	 * @return 
	 */
	public Set<String> getAllNodes(List<NodeRoad> roads);
	
	
	/** 
	 * 判断所有路径中是否有以end节点为终点的基本路径
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param begins
	 * @param ends
	 * @param roads
	 * @return 
	 */
	
	public Set<NodeRoad> deleteRoad(Set<String> begins, Set<String> ends,List<NodeRoad> roads);
	
	/** 
	 * 根据路径获取到所有的节点
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param all
	 * @param roads
	 * @param begins
	 * @param ends
	 * @param begin
	 * @param end
	 * @return 
	 */
	
	public Set<String> filterInvalidNode(Set<String> all, List<NodeRoad> roads,
			Set<String> begins, Set<String> ends,String begin,String end);
	
}
