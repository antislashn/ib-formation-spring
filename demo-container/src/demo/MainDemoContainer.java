package demo;

import container.ContextContainer;

public class MainDemoContainer {
	public static void main(String[] args) {
		ContextContainer ctx = new ContextContainer();
		ctx.accept(Contact.class);
		ctx.accept(Adresse.class);
		ctx.accept(ServiceImpl.class);
		
		ctx.inject();
		
//		Contact c = (Contact) ctx.getBean("contact");
//		c.sayHello();
//		
		IService service = (IService) ctx.getBean("service");
		int r = service.add(1,2,3,4,5,6);
		System.out.println(r);
	}
}
