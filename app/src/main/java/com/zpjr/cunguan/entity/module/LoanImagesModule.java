package com.zpjr.cunguan.entity.module;

import android.text.TextUtils;

import com.zpjr.cunguan.common.base.BaseModule;
import com.zpjr.cunguan.common.utils.ErrorInfo;

import java.util.List;

/**
 * Description:      公司图片信息
 * Autour：          LF
 * Date：            2017/7/19 14:41
 */

public class LoanImagesModule extends BaseModule {


    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<IMAGEBean> IMAGE;

        public List<IMAGEBean> getIMAGE() {
            return IMAGE;
        }
        public void setIMAGE(List<IMAGEBean> IMAGE) {
            this.IMAGE = IMAGE;
        }

        public static class IMAGEBean {
            private String content;
            private String id;
            private ProofBean proof;
            private String proofType;
            private String source;
            private long submitTime;
            private String uploader;
            private String uploaderId;
            private String uri;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public ProofBean getProof() {
                return proof;
            }

            public void setProof(ProofBean proof) {
                this.proof = proof;
            }

            public String getProofType() {
                return proofType;
            }

            public void setProofType(String proofType) {
                this.proofType = proofType;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public long getSubmitTime() {
                return submitTime;
            }

            public void setSubmitTime(long submitTime) {
                this.submitTime = submitTime;
            }

            public String getUploader() {
                return uploader;
            }

            public void setUploader(String uploader) {
                this.uploader = uploader;
            }

            public String getUploaderId() {
                return uploaderId;
            }

            public void setUploaderId(String uploaderId) {
                this.uploaderId = uploaderId;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public static class ProofBean {
                private String content;
                private String contentType;
                private boolean cover;
                private String description;
                private String employee;
                private String id;
                private boolean mosaic;
                /**
                 * entityId : 7EB0FB90-D482-4A25-A8C5-DC211A96B73D
                 * realm : LOANREQUEST
                 */
                private OwnerBean owner;
                private String proofType;
                private String source;
                private long submitTime;
                private String userId;

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getContentType() {
                    return contentType;
                }

                public void setContentType(String contentType) {
                    this.contentType = contentType;
                }

                public boolean isCover() {
                    return cover;
                }

                public void setCover(boolean cover) {
                    this.cover = cover;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getEmployee() {
                    return employee;
                }

                public void setEmployee(String employee) {
                    this.employee = employee;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public boolean isMosaic() {
                    return mosaic;
                }

                public void setMosaic(boolean mosaic) {
                    this.mosaic = mosaic;
                }

                public OwnerBean getOwner() {
                    return owner;
                }

                public void setOwner(OwnerBean owner) {
                    this.owner = owner;
                }

                public String getProofType() {
                    return proofType;
                }

                public void setProofType(String proofType) {
                    this.proofType = proofType;
                }

                public String getSource() {
                    return source;
                }

                public void setSource(String source) {
                    this.source = source;
                }

                public long getSubmitTime() {
                    return submitTime;
                }

                public void setSubmitTime(long submitTime) {
                    this.submitTime = submitTime;
                }

                public String getUserId() {
                    return userId;
                }

                public void setUserId(String userId) {
                    this.userId = userId;
                }

                public static class OwnerBean {
                    private String entityId;
                    private String realm;

                    public String getEntityId() {
                        return entityId;
                    }

                    public void setEntityId(String entityId) {
                        this.entityId = entityId;
                    }

                    public String getRealm() {
                        return realm;
                    }

                    public void setRealm(String realm) {
                        this.realm = realm;
                    }
                }
            }
        }
    }


    private boolean success;
    /**
     * 错误列表
     */
    private List<ApiErrorModule> error;

    private boolean  needToLogin = false;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }



    public List<ApiErrorModule> getError() {
        return error;
    }

    public void setError(List<ApiErrorModule> error) {
        this.error = error;
    }

    public boolean isNeedToLogin() {
        return needToLogin;
    }

    public void setNeedToLogin(boolean needToLogin) {
        this.needToLogin = needToLogin;
    }
    public boolean isError(){
        if(error != null && error.size()>0){
            return !TextUtils.isEmpty(error.get(0).getMessage());
        }else{
            return false;
        }
    }

    public String getErrorMessage(){
        try{
            return ErrorInfo.getMsg(error.get(0).getMessage());
        }catch(Exception e){
            return "未知错误";
        }
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", error=" + error +
                ", needToLogin=" + needToLogin +
                '}';
    }

}
