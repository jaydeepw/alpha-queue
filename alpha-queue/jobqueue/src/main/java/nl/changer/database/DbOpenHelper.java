package nl.changer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Helper class for {@link SqliteJobQueue} to handle database connection
 */
public class DbOpenHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "alpha-queue.db";

    private static final String JOB_TABLE_NAME = "queue";
    private static final SqlHelper.Property ID_COLUMN = new SqlHelper.Property("_id", "integer", 0);
    private static final SqlHelper.Property URL_COLUMN = new SqlHelper.Property("url", "varchar (200)", 1);
    // private static final SqlHelper.Property URL_COLUMN = new SqlHelper.Property("priority", "integer", 1);
    // private static final SqlHelper.Property GROUP_ID_COLUMN = new SqlHelper.Property("group_id", "text", 2);
    private static final SqlHelper.Property PAYLOAD_COLUMN = new SqlHelper.Property("payload", "string", 2);
    private static final SqlHelper.Property PAYLOAD_COLUMN = new SqlHelper.Property("base_job", "byte", 3);
    private static final SqlHelper.Property PAYLOAD_COLUMN = new SqlHelper.Property("base_job", "byte", 4);
    private static final SqlHelper.Property RUN_COUNT_COLUMN = new SqlHelper.Property("run_count", "integer", 5);
    // private static final SqlHelper.Property CREATED_NS_COLUMN = new SqlHelper.Property("created_ns", "long", 5);
    // private static final SqlHelper.Property DELAY_UNTIL_NS_COLUMN = new SqlHelper.Property("delay_until_ns", "long", 6);
    // private static final SqlHelper.Property RUNNING_SESSION_ID_COLUMN = new SqlHelper.Property("running_session_id", "long", 7);
    // private static final SqlHelper.Property REQUIRES_NETWORK_COLUMN = new SqlHelper.Property("requires_network", "integer", 8);

    /*package*/ static final int COLUMN_COUNT = 9;

    public DbOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String createQuery = SqlHelper.create(JOB_TABLE_NAME,
                ID_COLUMN,
                URL_COLUMN,
                GROUP_ID_COLUMN,
                RUN_COUNT_COLUMN,
                PAYLOAD_COLUMN,
                CREATED_NS_COLUMN,
                DELAY_UNTIL_NS_COLUMN,
                RUNNING_SESSION_ID_COLUMN,
                REQUIRES_NETWORK_COLUMN
        );

        database.execSQL(createQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SqlHelper.drop(JOB_TABLE_NAME));
        onCreate(sqLiteDatabase);
    }
}