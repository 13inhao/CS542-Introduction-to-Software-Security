import sqlite3
from sqlite3 import Error

def create_connection(db_file):
    """ create a database connection to a SQLite database """
    conn = None
    try:
        conn = sqlite3.connect(db_file)
        print(sqlite3.version)
        return conn
    except Error as e:
        print(e)

    return conn



def checkPW(u, p):

#This is the method you need to implement.  
#It has to have the SAME functionality as the exercise in Java.
#The first version has to be vulnerable to SQL injection attacks,
#and the second version must use prepared statements to mitigate 
#that attack.
#
#The parameters are:
#u: username
#p: password
#
#Return value:
#True if the login attempt was successful.
#False otherwise.

    conn = create_connection(r"/home/user/Desktop/EXERCISES/3.8.1_sql_injections/inPython/mydb/pythonsqlite.db")
    cur = conn.cursor()

    #sqlQuery = f"SELECT COUNT(*) AS count FROM USERS WHERE login == '{u}' AND password == '{p}' "

    sqlQuery = '''SELECT COUNT(*) AS count FROM USERS WHERE login == ? AND password == ?'''
    input = (u, p)

    try:
        #cur.execute(sqlQuery)
        cur.execute(sqlQuery, input)
        results = cur.fetchall()
        num_of_row = results[0][0]

        if (num_of_row == 0):
            return False
        else:
            return True
    finally:
        try:
            conn.close()
        except:
            print("Something went wrong")


if __name__ == '__main__':

    while 1:
       username = input("\n username: ")
       if username == "exit":
          quit()
       password = input("\n password: ")

       loginSuccess = False

       try:
          loginSuccess = checkPW(username, password)
       except:
          print("Something went wrong")

       if (loginSuccess):
           print("Login Successful! Welcome ",  username)
       else:
           print("Login Failure.")

