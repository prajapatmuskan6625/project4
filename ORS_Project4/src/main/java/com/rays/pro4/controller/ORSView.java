package com.rays.pro4.controller;


/**
 *  @author Muskan prajapat
 *
 */
public interface ORSView {


	 public String APP_CONTEXT = "/ORS_Project4";

	    public String LAYOUT_VIEW = "/BaseLayout.jsp";
	    public static String PAGE_FOLDER = "/jsp";

	    public String JAVA_DOC_VIEW = APP_CONTEXT + "/doc/index.html";


	    public String MARKSHEET_VIEW = PAGE_FOLDER + "/MarksheetView.jsp";

	    public String MARKSHEET_LIST_VIEW = PAGE_FOLDER + "/MarksheetListView.jsp";
	    public String GET_MARKSHEET_VIEW = PAGE_FOLDER + "/GetMarksheetView.jsp";
	    public String USER_VIEW = PAGE_FOLDER + "/UserView.jsp";
	    public String USER_LIST_VIEW = PAGE_FOLDER + "/UserListView.jsp";
	    public String COLLEGE_VIEW = PAGE_FOLDER + "/CollegeView.jsp";
	    public String COLLEGE_LIST_VIEW = PAGE_FOLDER + "/CollegeListView.jsp";
	    public String STUDENT_VIEW = PAGE_FOLDER + "/StudentView.jsp";
	    public String STUDENT_LIST_VIEW = PAGE_FOLDER + "/StudentListView.jsp";
	    public String ROLE_VIEW = PAGE_FOLDER + "/RoleView.jsp";
	    public String ROLE_LIST_VIEW = PAGE_FOLDER + "/RoleListView.jsp";
	    public String USER_REGISTRATION_VIEW = PAGE_FOLDER
	            + "/UserRegistrationView.jsp";
	    public String LOGIN_VIEW = PAGE_FOLDER + "/LoginView.jsp";
	    public static String WELCOME_VIEW = PAGE_FOLDER + "/Welcome.jsp";
	    public String CHANGE_PASSWORD_VIEW = PAGE_FOLDER
	            + "/ChangePasswordView.jsp";
	    public String MY_PROFILE_VIEW = PAGE_FOLDER + "/MyProfileView.jsp";
	    public String FORGET_PASSWORD_VIEW = PAGE_FOLDER
	            + "/ForgetPasswordView.jsp";
	    public String MARKSHEET_MERIT_LIST_VIEW = PAGE_FOLDER
	            + "/MarksheetMeritListView.jsp";
	    public String COURSE_VIEW = PAGE_FOLDER + "/CourseView.jsp";
	    public String COURSE_LIST_VIEW = PAGE_FOLDER + "/CourseListView.jsp";
	    public String FACULTY_VIEW = PAGE_FOLDER + "/FacultyView.jsp";
		public String FACULTY_LIST_VIEW = PAGE_FOLDER + "/FacultyListView.jsp";
		 public String SUBJECT_VIEW = PAGE_FOLDER + "/SubjectView.jsp";
		 public String SUBJECT_LIST_VIEW = PAGE_FOLDER + "/SubjectListView.jsp";
		 public String TIMETABLE_VIEW = PAGE_FOLDER + "/TimeTableView.jsp";
		 public String TIMETABLE_LIST_VIEW = PAGE_FOLDER + "/TimeTableListView.jsp";
		 public String ERROR_VIEW = PAGE_FOLDER + "/ErrorView.jsp";
		 public String EMPLOYEE_LIST_VIEW = PAGE_FOLDER + "/EmployeeListView.jsp";
		 public String EMPLOYEE_VIEW = PAGE_FOLDER + "/EmployeeView.jsp";
		 public String LEAD_LIST_VIEW = PAGE_FOLDER + "/LeadListView.jsp";
		 public String LEAD_VIEW = PAGE_FOLDER + "/LeadView.jsp";
		 public String BANK_VIEW = PAGE_FOLDER + "/BankView.jsp";
		 public String BANK_LIST_VIEW = PAGE_FOLDER + "/BankListView.jsp";
		 public String PAYMENT_LIST_VIEW = PAGE_FOLDER + "/PaymentListView.jsp" ;
		 public String PAYMENT_VIEW = PAGE_FOLDER + "/PaymentView.jsp" ;
		 
		 public String PRODUCT_LIST_VIEW = PAGE_FOLDER + "/ProductListView.jsp";
         public String PRODUCT_VIEW = PAGE_FOLDER + "/ProductView.jsp";
         public String DOCTOR_VIEW = PAGE_FOLDER + "/DoctorView.jsp";
         public String DOCTOR_LIST_VIEW = PAGE_FOLDER + "/DoctorListView.jsp";
         public String ORDER_VIEW = PAGE_FOLDER + "/OrderView.jsp";
         public String ORDER_LIST_VIEW = PAGE_FOLDER + "/OrderListView.jsp";
         public String JOB_VIEW = PAGE_FOLDER + "/JobView.jsp";
         public String JOB_LIST_VIEW = PAGE_FOLDER + "/JobListView.jsp";
         public String SALARY_VIEW = PAGE_FOLDER + "/SalaryView.jsp";
         public String SALARY_LIST_VIEW = PAGE_FOLDER + "/SalaryListView.jsp";
     	public String WISH_VIEW = PAGE_FOLDER + "/WishView.jsp";
     	public String WISH_LIST_VIEW = PAGE_FOLDER + "/WishListView.jsp";
    	public String PROJECT_VIEW = PAGE_FOLDER + "/ProjectView.jsp";
     	public String PROJECT_LIST_VIEW = PAGE_FOLDER + "/ProjectListView.jsp";
     	public String CLIENT_VIEW = PAGE_FOLDER + "/ClientView.jsp";
     	public String CLIENT_LIST_VIEW = PAGE_FOLDER + "/ClientListView.jsp";
     	public String FOLLOWUP_VIEW = PAGE_FOLDER + "/FollowUpView.jsp";
     	public String FOLLOWUP_LIST_VIEW = PAGE_FOLDER + "/FollowUpListView.jsp";
     	public String FIELD_VIEW = PAGE_FOLDER  +"/FieldView.jsp";
    	public String FIELD_LIST_VIEW = PAGE_FOLDER  +"/FieldListView.jsp";
    	public String  CUSTOMER_VIEW = PAGE_FOLDER+"/CustomerView.jsp";
    	public String CUSTOMER_LIST_VIEW = PAGE_FOLDER + "/CustomerListView.jsp";
    	public String OWNER_VIEW = PAGE_FOLDER + "/OwnerView.jsp";
     	public String OWNER_LIST_VIEW = PAGE_FOLDER + "/OwnerListView.jsp";
     	public String  PATIENT_VIEW = PAGE_FOLDER  + "/PatientView.jsp";
    	public String PATIENT_LIST_VIEW = PAGE_FOLDER  +"/PatientListView.jsp";
    	public String INITIATIVE_VIEW = PAGE_FOLDER + "/InitiativeView.jsp";
     	public String INITIATIVE_LIST_VIEW = PAGE_FOLDER + "/InitiativeListView.jsp";
     







		
			
		 
		 //   public String ERROR_VIEW5 = PAGE_FOLDER + "/ErrorView5.jsp";
		    

	
	    public String MARKSHEET_CTL = APP_CONTEXT + "/ctl/MarksheetCtl";
	    public String MARKSHEET_LIST_CTL = APP_CONTEXT + "/ctl/MarksheetListCtl";
	    public String USER_CTL = APP_CONTEXT + "/ctl/UserCtl";
	    public String USER_LIST_CTL = APP_CONTEXT + "/ctl/UserListCtl";
	    public String COLLEGE_CTL = APP_CONTEXT + "/ctl/CollegeCtl";
	    public String COLLEGE_LIST_CTL = APP_CONTEXT + "/ctl/CollegeListCtl";
	    public String STUDENT_CTL = APP_CONTEXT + "/ctl/StudentCtl";
	    public String STUDENT_LIST_CTL = APP_CONTEXT + "/ctl/StudentListCtl";
	    public String ROLE_CTL = APP_CONTEXT + "/ctl/RoleCtl";
	    public String ROLE_LIST_CTL = APP_CONTEXT + "/ctl/RoleListCtl";
	    public String USER_REGISTRATION_CTL = APP_CONTEXT + "/UserRegistrationCtl";
	    public String LOGIN_CTL = APP_CONTEXT + "/LoginCtl";
	    public String WELCOME_CTL = APP_CONTEXT + "/WelcomeCtl";
	    public String LOGOUT_CTL = APP_CONTEXT + "/LoginCtl";
	    public String GET_MARKSHEET_CTL = APP_CONTEXT + "/ctl/GetMarksheetCtl";
	    public String CHANGE_PASSWORD_CTL = APP_CONTEXT + "/ctl/ChangePasswordCtl";
	    public String MY_PROFILE_CTL = APP_CONTEXT + "/ctl/MyProfileCtl";
	    public String FORGET_PASSWORD_CTL = APP_CONTEXT + "/ForgetPasswordCtl";
	    public String MARKSHEET_MERIT_LIST_CTL = APP_CONTEXT
	            + "/ctl/MarksheetMeritListCtl";
	    public String COURSE_CTL = APP_CONTEXT + "/ctl/CourseCtl";
	    public String COURSE_LIST_CTL = APP_CONTEXT + "/ctl/CourseListCtl";
	    public String FACULTY_CTL = APP_CONTEXT + "/ctl/FacultyCtl";
		public String FACULTY_LIST_CTL = APP_CONTEXT + "/ctl/FacultyListCtl";
		public String SUBJECT_CTL = APP_CONTEXT + "/ctl/SubjectCtl";
		public String SUBJECT_LIST_CTL = APP_CONTEXT + "/ctl/SubjectListCtl";
		public String TIMETABLE_CTL = APP_CONTEXT + "/ctl/TimeTableCtl";
	    public String TIMETABLE_LIST_CTL = APP_CONTEXT + "/ctl/TimeTableListCtl";
	    public String ERROR_CTL = APP_CONTEXT + "/ErrorCtl";

		public String EMPLOYEE_CTL = APP_CONTEXT + "/ctl/EmployeeCtl";

		public String EMPLOYEE_LIST_CTL = APP_CONTEXT + "/ctl/EmployeeListCtl";

		public String LEAD_LIST_CTL = APP_CONTEXT + "/ctl/LeadListCtl";
		public String LEAD_CTL = APP_CONTEXT + "/ctl/LeadCtl";
		public String BANK_CTL = APP_CONTEXT + "/ctl/BankCtl";
		public String BANK_LIST_CTL = APP_CONTEXT + "/ctl/BankListCtl";

		public String PAYMENT_LIST_CTL = APP_CONTEXT + "/ctl/PaymentListCtl";
		public String PAYMENT_CTL = APP_CONTEXT + "/ctl/PaymentCtl";
		
		
		
		public String PRODUCT_LIST_CTL = APP_CONTEXT + "/ctl/ProductListCtl";
	    public String PRODUCT_CTL = APP_CONTEXT + "/ctl/ProductCtl";
	    public String EMPLOYEEROLE_LIST_CTL = APP_CONTEXT + "/ctl/ProductListCtl";
	    public String EMPLOYEEROLE_CTL = APP_CONTEXT + "/ctl/EmployeeCtl";

		public String DOCTOR_CTL = APP_CONTEXT + "/ctl/DoctorCtl";

		public String DOCTOR_LIST_CTL = APP_CONTEXT + "/ctl/DoctorListCtl";

		public String ORDER_LIST_CTL = APP_CONTEXT + "/ctl/OrderListCtl";
		public String ORDER_CTL = APP_CONTEXT + "/ctl/OrderCtl";

		public String JOB_LIST_CTL = APP_CONTEXT + "/ctl/JobListCtl";
		public String JOB_CTL = APP_CONTEXT + "/ctl/JobCtl";
		public String SALARY_CTL = APP_CONTEXT + "/ctl/SalaryCtl";
		public String SALARY_LIST_CTL = APP_CONTEXT + "/ctl/SalaryListCtl";

		public String WISH_LIST_CTL = APP_CONTEXT + "/ctl/WishListCtl";
		public String WISH_CTL = APP_CONTEXT + "/ctl/WishCtl";
		public String PROJECT_LIST_CTL = APP_CONTEXT + "/ctl/ProjectListCtl";
		public String PROJECT_CTL = APP_CONTEXT + "/ctl/ProjectCtl";
		public String CLIENT_LIST_CTL = APP_CONTEXT + "/ctl/ClientListCtl";
		public String CLIENT_CTL = APP_CONTEXT + "/ctl/ClientCtl";
		public String FOLLOWUP_LIST_CTL = APP_CONTEXT + "/ctl/FollowUpListCtl";
		public String FOLLOWUP_CTL = APP_CONTEXT + "/ctl/FollowUpCtl";
		public String FIELD_CTL = APP_CONTEXT +"/ctl/FieldCtl";
		public String FIELD_LIST_CTL = APP_CONTEXT +"/ctl/FieldListCtl";
		public String CUSTOMER_LIST_CTL = APP_CONTEXT +"/ctl/CustomerListCtl";

		public String CUSTOMER_CTL = APP_CONTEXT + "/ctl/CustomerCtl";
		public String OWNER_LIST_CTL = APP_CONTEXT + "/ctl/OwnerListCtl";
		public String OWNER_CTL = APP_CONTEXT + "/ctl/OwnerCtl";
		public String PATIENT_LIST_CTL = APP_CONTEXT + "/ctl/PatientListCtl";
		public String PATIENT_CTL = APP_CONTEXT +"/ctl/PatientCtl";
		public String INITIATIVE_CTL = APP_CONTEXT + "/ctl/InitiativeCtl";
		public String INITIATIVE_LIST_CTL = APP_CONTEXT + "/ctl/InitiativeListCtl";
		
		
	

	
		

		
		


	


		

		

		
		

	
	
}
