package com.xxh.dev.ali;

import android.util.Log;

import com.aliyun.pds.client.Client;
import com.aliyun.pds.client.models.Config;
import com.aliyun.pds.client.models.GetDriveModel;
import com.aliyun.pds.client.models.GetDriveRequest;

public class FileObject {
    private Client mClient;
    private String mDomainId = "zjk1373";
    private String mAccessToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIxMzgzMDcyNyIsImN1c3RvbUpzb24iOiJ7XCJjbGllbnRJZFwiOlwic29oOFJnelpiUE9pNUlyclwiLFwiZG9tYWluSWRcIjpcInpqazEzNzNcIixcInNjb3BlXCI6W1wiRFJJVkUuQUxMXCIsXCJTSEFSRS5BTExcIixcIkZJTEUuQUxMXCIsXCJVU0VSLkFMTFwiLFwiU1RPUkFHRS5BTExcIixcIlNUT1JBR0VGSUxFLkxJU1RcIixcIkFDQ09VTlQuQUxMXCIsXCJCQVRDSFwiLFwiTUVNQkVSU0hJUC5BTExcIixcIkdST1VQLkFMTFwiXSxcInJvbGVcIjpcInVzZXJcIixcInJlZlwiOlwiXCIsXCJkZXZpY2VfaWRcIjpcIjJhOWE1NmU0ODNkZTQ1NDliMmMyMTYxOGZlM2I4YThlXCJ9IiwiZXhwIjoxNjU1Nzk3Njk4LCJpYXQiOjE2NTU3OTA0Mzh9.umY-mb16F69IcMTm-T81qLoLQp1jJ0zEI40VEe3Pl82r7V4wpWogzVZmJYKjiQyXQdzOG7xnrrqDKfzrQ4qBNO9SZkqu1MnSki15GxxPhsac-Px53Ow9VXJ2QMO9uNExyu4ahdgttWSh7hTKm2NtScguIhmy9QPZOpXQP-tsFc8";
    private String mDriveId = "196490";

    public void init() throws Exception {

    }

    public void getCloudSpace() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Config config = new Config();
                    config.domainId = mDomainId;
                    config.accessToken = mAccessToken;
                    Log.d("xxh21","mDomainId="+mDomainId+" accessToken="+mAccessToken);
                    mClient = new Client(config);
                    String size = "0";
                    GetDriveRequest request = new GetDriveRequest();
                    request.driveId = mDriveId;
                    Log.d("xxh21","driveId="+GetDriveRequest.class);
                    GetDriveModel response = mClient.getDrive(request);
                    size = response.body.totalSize + "";
                    Log.d("xxh21", response.body.totalSize + " "+response.body.domainId+" "+response.body.usedSize+" "+response.body.driveId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        /*String size = "0";
        GetDriveRequest request = new GetDriveRequest();
        request.driveId = mDriveId;
        try {
            GetDriveModel response = mClient.getDrive(request);
            size = response.body.totalSize + "";
            Log.d("xxh", response.body.totalSize + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;*/
    }


//getCloudSpace request:b90@1448903

//getCloudSpace request:b90@7412029


//d=com.aliyun.pds.client.models.GetDriveRequest@db38576
}
