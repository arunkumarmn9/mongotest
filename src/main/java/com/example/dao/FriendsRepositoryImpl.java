package com.example.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.Friends;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

import java.util.ArrayList;
@Component 
public   class FriendsRepositoryImpl implements FriendsRepositoryCustom{
	
	@Autowired
	MongoTemplate mongoTemplate;
	@Override
	public List  aggregate() {
	//template
	/*	Aggregation agg = newAggregation(
			match(Criteria.where("_id").lt(10)),
			group("hosting").count().as("total"),
			project("total").and("hosting").previousOperation(),
			sort(Sort.Direction.DESC, "total")
				
		);
*/
		
		//get the number episodes per season
		Aggregation agg = newAggregation(
				group("season").max("number").as("episodes"),
				 /*match(Criteria.where("seasons").gt(3)),*/
				sort(Sort.Direction.DESC,"season")
				 
			);
		
		//expected output of the above aggregation
		/*[{"_id":8.0,"episodes":24.0},
		 * {"_id":9.0,"episodes":24.0},
		 * {"_id":7.0,"episodes":24.0},
		 * {"_id":6.0,"episodes":25.0},
		 * {"_id":3.0,"episodes":25.0},
		 * {"_id":2.0,"episodes":24.0},
		 * {"_id":4.0,"episodes":24.0},
		 * {"_id":1.0,"episodes":24.0},
		 * {"_id":5.0,"episodes":24.0}]*/

		//Convert the aggregation result into a List
		AggregationResults<Object> groupResults 
			= mongoTemplate.aggregate(agg, "samples_friends", Object.class);
		List result = groupResults.getMappedResults();
		
		return result;
	

}
	}
