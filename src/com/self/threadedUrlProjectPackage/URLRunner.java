/**
 * URLRunner class implements the runnable interface. The threads spawned 
 * take a runnable object from this class.
 * 
 * @author Navneet
 */

package com.self.threadedUrlProjectPackage;

class URLRunner implements Runnable
{
	private String url;
	private Integer threadNo;
	private ThreadedURLClient reference;
	private ContextWrapper wrapper;
	
	public URLRunner(String sentUrl, Integer sentThreadNo, ThreadedURLClient referenceObj,ContextWrapper sentWrapper)
	{
		url = sentUrl;
		threadNo = sentThreadNo;
		reference = referenceObj;
		wrapper = sentWrapper;
		
	}

	@Override
	public void run() {
		long threadStartTime = System.currentTimeMillis();
		try {
			reference.getResponse(url,wrapper.getStatisticMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		long threadEndTime = System.currentTimeMillis();
		System.out.println("Time taken by Thread "+threadNo+" is: "+(threadEndTime-threadStartTime));
	}
	
}