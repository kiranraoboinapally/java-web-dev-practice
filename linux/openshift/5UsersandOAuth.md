
---

# **Topic 5: Users and OAuth in OpenShift**

OpenShift integrates **user authentication** tightly with Kubernetes APIs. Every action in the cluster is performed by a **User**, whether human or automation.

---

## **1️⃣ What is a User in OpenShift?**

* **Definition:**
  A User is **an entity that interacts with the OpenShift API Server**, representing a human or automation actor.
* Usually **automatically created** after a successful login (OAuth).
* Users can have **roles and permissions** (via RBAC).

**Key Points:**

| Feature     | Explanation                                      |
| ----------- | ------------------------------------------------ |
| Identity    | Represents an actor (human or automation)        |
| Access      | Can interact with **API Server** and Web Console |
| Creation    | Often automatic via **OAuth login**              |
| Permissions | Controlled via **Roles and RoleBindings**        |

**Memory Tip:**

> User = “actor recognized by OpenShift API”

---

## **2️⃣ Authentication Methods in OpenShift**

OpenShift supports **two main methods to authenticate requests to the API**:

1. **OAuth Access Tokens**

   * Used for **interactive logins** (`oc login`) or web console sessions.
   * Tokens are short-lived, managed by OpenShift’s **OAuth server**.

2. **X.509 Client Certificates**

   * Used for **automated systems** or service accounts.
   * Certificates are pre-issued and can authenticate **without manual login**.

**Other methods like LDAP or Kerberos** can be integrated, but the **core two are OAuth tokens and X.509 certificates**.

---

## **3️⃣ The OAuth Server in OpenShift**

* OpenShift includes an **integrated OAuth server**.
* Responsibilities:

  1. Validates user credentials (password, LDAP, etc.)
  2. Issues **OAuth tokens** for API access
* When a user logs in via `oc login` or Web Console:

  * OAuth server authenticates the user
  * Returns a **token**
  * Token is used for all future API requests

**Visual Example:**

```text
User logs in --> OAuth Server --> Issues Token --> API Server validates token
```

* Tokens allow **automated, secure access** to the cluster.

---

## **4️⃣ Users and API Access**

* After login, the user is recognized in the system.
* Users can be assigned **roles** (like admin, developer).
* RBAC ensures **what actions the user can perform** on which resources.

Example:

```text
User: student
Role: developer
Namespace: dev-project
Permissions: create pods, view services
```

* In your lab setup:

  * Standard user: `student`
  * Password: `student`
  * Root password on systems: `redhat`

---

## **5️⃣ Summary Table**

| Concept        | Explanation                                                 |
| -------------- | ----------------------------------------------------------- |
| User           | Actor interacting with OpenShift API                        |
| Authentication | OAuth tokens (interactive), X.509 certificates (automation) |
| OAuth Server   | Issues tokens, validates logins                             |
| Access Control | Managed via RBAC roles & rolebindings                       |

**Memory Tip:**

> OAuth server = “token dispenser”
> User = “actor recognized by API server”

---

