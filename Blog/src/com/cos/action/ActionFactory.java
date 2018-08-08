package com.cos.action;

import com.cos.controller.member.MemberJoingAction;

public class ActionFactory {
	   private static String naming ="ActionFactory : ";
	   
	   private static ActionFactory instance = new ActionFactory();
	   private ActionFactory() {}
	   
	   public static ActionFactory getInstance() {
		   return instance;
	   }
	   public Action getAction(String cmd) {
		   if(cmd.equals("member_join")) {
			   return new MemberJoingAction();
		   }
		   return null;
	   }
}
