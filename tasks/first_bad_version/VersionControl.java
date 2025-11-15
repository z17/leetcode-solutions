package first_bad_version;


public abstract class VersionControl {
    public int badVersion;


    public boolean isBadVersion(int version) {
        return version >= badVersion;
    }
}