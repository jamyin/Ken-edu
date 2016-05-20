package com.ssic.education.app.token;

import java.io.Serializable;

/**		
 * <p>Title: Token </p>
 * <p>Description: 令牌模型类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月19日 上午10:53:08	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月19日 上午10:53:08</p>
 * <p>修改备注：</p>
 */
public class Token implements Serializable {

	private static final long serialVersionUID = -754659525548951914L;
	
	private String signature;
	private long timestamp;

	public Token(String signature, long timestamp) {
		if (signature == null)
			throw new IllegalArgumentException("signature can not be null");

		this.timestamp = timestamp;
		this.signature = signature;
	}

	public Token(String signature) {
		if (signature == null)
			throw new IllegalArgumentException("signature can not be null");

		this.signature = signature;
	}

	/**
	 * Returns a string containing the unique signatureentifier assigned to this token.
	 */
	public String getSignature() {
		return signature;
	}

	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * timestamp 不予考虑, 因为就算 timestamp 不同也认为是相同的 token.
	 */
	public int hashCode() {
		return signature.hashCode();
	}

	public boolean equals(Object object) {
		if (object instanceof Token)
			return ((Token) object).signature.equals(this.signature);
		return false;
	}

	@Override
	public String toString() {
		return "Token [signature=" + signature + ", timestamp=" + timestamp + "]";
	}

}
