package com.clx.Utility.Enum;

public class ErrorMessages {
	public enum ErrorMessage{
		VALIDUN_BLANKPWD("Enter Password."),
		VALIDUN_WRONGPWD("Unauthorized: Wrong username or password."),
		WRONGUN_VALIDPWD("Unauthorized: Wrong username or password."),
		WRONGUN_WRONGPWD("Unauthorized: Wrong username or password.");

		private String enumValue;
		ErrorMessage (String value)
		{
			this.enumValue = value;
		}
		public String getText()
		{
			return this.enumValue;
		}
	}

}
