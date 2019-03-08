package com.davidphan.digitalvideorecorder.data.remote;

import com.davidphan.digitalvideorecorder.data.model.Program;
import com.davidphan.digitalvideorecorder.data.model.Recording;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ProgramService {

    // HTTP GET /programs?channel_number=1
    @GET("programs")
    Call<Program> listProgramsForChannel(@Query("channel_number") String channelNumber);

    // TODO return a Response that either returns Recording or RecordingFailure
    // HTTP POST /recording?channel_number=1&program_id=1234
    @POST("recording")
    Call<Recording> bookRecording(@Query("channel_number") String channelNumber,
                                  @Query("program_id") String programId);

    // HTTP DELETE /recording?recording_id=3456
    @DELETE("recording")
    Call<Response> cancelRecording(@Query("recording_id") String recordingId);

}
