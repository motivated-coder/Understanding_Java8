package com.skd.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AadharID{
    int id;
    String name;
    static Map<Integer,String> aadharDetails;

    static {
        aadharDetails=new HashMap<>();
        aadharDetails=new HashMap<>();
        aadharDetails.put(18838,"Sumeet Dwivedi");
        aadharDetails.put(14838,"Peter England");
        aadharDetails.put(11938,"Sanvi Sharma");
    }

    public static List<Map.Entry<Integer,String>> getAadharDetailsAsListEntry(){
        List<Map.Entry<Integer,String>> entries = aadharDetails.entrySet().stream().collect(Collectors.toList());
        return entries;
    }

    public static Map<Integer,String> getAadharDetails(){
        return aadharDetails;
    }
}
