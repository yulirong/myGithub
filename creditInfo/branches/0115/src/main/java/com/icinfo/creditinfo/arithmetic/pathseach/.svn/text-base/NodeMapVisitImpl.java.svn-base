package com.icinfo.creditinfo.arithmetic.pathseach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.icinfo.creditinfo.bean.analy.cranalyentrelation.CrAnalyEntRelation;

/** 
 * 描述: 确定路径
 * @author gqf
 * @date 2015年11月20日  
 */
public class NodeMapVisitImpl implements Visit {

	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param relationList
	 * @return 
	 */
	@Override
	public List<NodeRoad> init(List<CrAnalyEntRelation> relationList) {
		List<NodeRoad> list = new ArrayList<NodeRoad>();
		if(relationList == null) return null;
		for(CrAnalyEntRelation entRelation : relationList){
			list.add(new NodeRoad(entRelation.getSfzjhm(),entRelation.getNbxh()));
			list.add(new NodeRoad(entRelation.getNbxh(),entRelation.getSfzjhm()));
		}
		/*for(CrAnalyEntRelation entRelation : relationList){
			list.add(new NodeRoad(entRelation.getNbxh(),entRelation.getSfzjhm()));
		}*/
		
		return list;
	}

	/** 
	 * 判断所有路径中是否有以begin节点为起点的基本路径
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param begin
	 * @param end
	 * @param roads
	 * @return 
	 */
	@Override
	public boolean existBegin(String begin, String end, List<NodeRoad> roads) {
		if (begin.equals(end)) {
			return true;
		}
		boolean result = false;
		for (NodeRoad r : roads) {
			if (r.getBegin().equals(begin)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param end
	 * @param begin
	 * @param roads
	 * @return 
	 */
	@Override
	public boolean existEnd(String end, String begin, List<NodeRoad> roads) {
		if (end.equals(begin)) {
			return true;
		}
		boolean result = false;
		for (NodeRoad r : roads) {
			if (r.getEnd().equals(end)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/** 
	 * 返回路径
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param roads
	 * @return 
	 */
	@Override
	public Set<String> getAllNodes(List<NodeRoad> roads) {
		Set<String> nodes = new HashSet<String>();
		for(NodeRoad r : roads) {
			nodes.add(r.getBegin());
			nodes.add(r.getEnd());
		}
		return nodes;
	}

	/** 
	 * 判断所有路径中是否有以end节点为终点的基本路径
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param begins
	 * @param ends
	 * @param roads
	 * @return 
	 */
	@Override
	public Set<NodeRoad> deleteRoad(Set<String> begins, Set<String> ends,
			List<NodeRoad> roads) {
		Set<NodeRoad> set = new HashSet<NodeRoad>();
		for (String str : begins) {
			for (NodeRoad r : roads) {
				if (r.getBegin().equals(str)) {
					set.add(r);
				}
				if (r.getEnd().equals(str)) {
					set.add(r);
				}
			}
		}
		return set;
	}

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
	@Override
	public Set<String> filterInvalidNode(Set<String> all, List<NodeRoad> roads,
			Set<String> begins, Set<String> ends, String begin, String end) {
		Set<String> result = new HashSet<String>();
		boolean isBegin = true;
		boolean isEnd = true;
		for (String str : all) {
			if (!existEnd(str, begin,roads)) { // 没有以此节点结尾的路径，则证明此节点为无用节点
				isBegin = false;
				begins.add(str);
				// 删除以此节点为开始的路径
			} else if (!existBegin(str,end, roads)) {// 没有以此节点开头的路径，则证明此节点为无用节点
				isEnd = false;
				ends.add(str);
			} else {
				result.add(str); // 有用的节点
			}
		}
		if (isBegin == true && isEnd == true) {
			return result;
		} else {
			return filterInvalidNode(result, roads, begins, ends,begin,end);
		}
	}

}
