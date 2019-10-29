################################
# Muangkong Yang               # 
# CSCD330 - Computing Networks #
# Assignment 1 - Web Client    #
################################

#!/usr/bin/python           # This is client.py file

import socket               # Import socket module
import sys                  # Import system module

print("#################################################################################")
    #WWW.EXAMPLE.COM
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)       # Create a socket object
print("Socket created")
hostName = 'www.example.com'    

try:
    host = socket.gethostbyname(hostName)                   # Plug socket to host
except socket.gaierror:
    print("Hostname could not be resolved. Exiting")
    sys.exit()
    
port = 80                                                   # Reserve a port for service
s.connect((host, port))                                     # Connect to server
print("the socket has successfully connected to", hostName, "on port ==", host)

message = "GET / HTTP/1.1\r\nHost: www.example.com\r\n\r\n".encode(); # Create message

try:
    s.sendall(message)                                      # Send message
except socket.error:
    print ("Send failed")
    sys.exit()

print("Message send successfully")
reply = s.recv(4096)                                        # Recieve server message
print(reply)                                                # Print the message
s.close()                                                   # Close socket
print("Socket closed")
print("#################################################################################")
    #TEXT.NPR.ORG
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)   
print("Socket created")
hostName = 'text.npr.org'    

try:
    host = socket.gethostbyname(hostName)
except socket.gaierror:
    print("Hostname could not be resolved. Exiting")
    sys.exit()
    
port = 80                   
s.connect((host, port))     
print("the socket has successfully connected to", hostName, "on port ==", host)

message = "GET / HTTP/1.1\r\nHost: text.npr.org\r\n\r\n".encode();

try:
    s.sendall(message)
except socket.error:
    print ("Send failed")
    sys.exit()

print("Message send successfully")
reply = s.recv(4096)
print(reply)
s.close()
print("Socket closed")
print("#################################################################################")
    #HUGOTUNIUS.SE
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  
print("Socket created")
hostName = 'hugotunius.se'    

try:
    host = socket.gethostbyname(hostName)
except socket.gaierror:
    print("Hostname could not be resolved. Exiting")
    sys.exit()
    
port = 80                   
s.connect((host, port))    
print("the socket has successfully connected to", hostName, "on port ==", host)

message = "GET / HTTP/1.1\r\nHost: hugotunius.se\r\n\r\n".encode();

try:
    s.sendall(message)
except socket.error:
    print ("Send failed")
    sys.exit()

print("Message send successfully")
reply = s.recv(4096)
print(reply)
s.close()
print("Socket closed")
print("#################################################################################")
    #LUCUMR.POCOO.ORG
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)  
print("Socket created")
hostName = 'lucumr.pocoo.org'    

try:
    host = socket.gethostbyname(hostName)
except socket.gaierror:
    print("Hostname could not be resolved. Exiting")
    sys.exit()
    
port = 80                   
s.connect((host, port))     
print("the socket has successfully connected to", hostName, "on port ==", host)

message = "GET / HTTP/1.1\r\nHost: lucumr.pocoo.org\r\n\r\n".encode();

try:
    s.sendall(message)
except socket.error:
    print ("Send failed")
    sys.exit()

print("Message send successfully")
reply = s.recv(4096)
print(reply)
s.close()
print("Socket closed")
print("#################################################################################")
    #GWERN.NET
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)   
print("Socket created")
hostName = 'www.gwern.net'  

try:
    host = socket.gethostbyname(hostName)
except socket.gaierror:
    print("Hostname could not be resolved. Exiting")
    sys.exit()
    
port = 80                 
s.connect((host, port))     
print("the socket has successfully connected to", hostName, "on port ==", host)

message = "GET / HTTP/1.1\r\nHost: www.gwern.net\r\n\r\n".encode();

try:
    s.sendall(message)
except socket.error:
    print ("Send failed")
    sys.exit()

print("Message send successfully")
reply = s.recv(4096)
print(reply)
s.close()
print("Socket closed")
print("#################################################################################")
